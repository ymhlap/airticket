package com.ymh.airticket.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

/**
 * @Author chenmin
 * @Description 七牛云工具类
 */
public class QiniuUtils {

    /**
     * AK/SK 存储空间名称
     * 设置好账号的ACCESS_KEY和SECRET_KEY
     */
    private static String ACCESS_KEY = "cnwU12jkbD56MnicYx5l0XX8OQ2A7A-EexjkHHZ-";
    private static String SECRET_KEY = "izcFrmFop0Hzj2NUtLf_4sEVjBqEmTm9HRUbNpE5";

    /**
     * 要上传的空间
     * 七牛云空间存储空间名称
     */
    public static final String bucket = "igeek-health";

    /**
     * 七牛绑定的自定义域名
     */
    public static final String BUCKET_HOST_NAME = "http://sg51rwy0z.hd-bkt.clouddn.com";
    /**
     * 你的文件上传路径
     */
    public static final String DOMAIN = "";

    /**
     * 获取Token
     * @param bucketName  指定的七牛云空间存储空间名称
     * @return
     */
    public static String token(String bucketName) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucketName);
        return upToken;
    }

    /**
     * 默认存储空间，获取Token
     * @return
     */
    public static String token() {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    /**
     * 获取存储区域
     *
     * @param zoneName
     * @return
     */
    private static Zone getZone(Integer zoneName) {
        //默认北美
        Zone zone = Zone.zoneNa0();
        if (null == zoneName) {
            return zone;
        }
        if (zoneName == 0) {
            //华东
            zone = Zone.zone0();
        }
        if (zoneName == 1) {
            //华北
            zone = Zone.zone1();
        }
        if (zoneName == 2) {
            //华南
            zone = Zone.zone2();
        }
        return zone;

    }

    /**
     * 上传图片
     *
     * @param filePath   图片路径
     * @param fileName   文件名字
     * @return 上传成功后，返回七牛云上的外链地址
     */
    public static String uploadForQiniu(String filePath,String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //创建上传对象
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        try {
            //上传
            Response response = uploadManager.put(filePath, key, token(bucket));
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.out.println(fileName + "----文件上传失败----" + r.toString());
            try {
                System.err.println(r.bodyString());
                System.out.println(fileName + "----文件上传失败----" + r.toString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 通过字节数组上传
     *
     * @param bytes     字节数组
     * @param fileName  文件名字
     * @return  上传成功后，返回七牛云上的外链地址
     */
    public static String uploadForQiniu(byte[] bytes, String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //创建上传对象
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        try {
            //上传
            Response response = uploadManager.put(bytes, key, token(bucket));
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.out.println(fileName + "----文件上传失败----" + r.toString());
            try {
                System.err.println(r.bodyString());
                System.out.println(fileName + "----文件上传失败----" + r.toString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 通过输入流上传
     *
     * @param inputStream  上传文件的流对象
     * @param fileName     文件名字
     * @return  上传成功后，七牛云上的外链地址
     */
    public static String uploadForQiniu(InputStream inputStream , String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //创建上传对象
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //String key = String.valueOf(System.currentTimeMillis());
        String key = fileName;
        try {
            try {
                //上传
                Response response = uploadManager.put(inputStream, key, token(bucket), null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            } catch (QiniuException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 根据Key值删除云端文件
     * @param fileName
     */
    public static boolean deleteFromQiniu(String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //鉴权
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth, cfg);

        //删除
        String key = fileName;
        try {
            if(key!=null){
                Response response = bucketManager.delete(bucket, key);
                if (response.statusCode == 200) {
                    return true;
                }
            }
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.out.println(key + "----删除失败----" + ex.code());
        }
        return false;
    }
}
