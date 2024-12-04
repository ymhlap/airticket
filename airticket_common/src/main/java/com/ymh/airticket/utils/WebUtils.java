package com.ymh.airticket.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author chenmin
 * @Description TODO
 * @Date 2023/12/21
 *
 * 将字符串渲染到客户端，向响应之中写入中聚类
 */
public class WebUtils {

    /**
     * 将字符串渲染到客户端
     * @param response 渲染对象
     * @param string   待渲染的字符串
     */
    public static String renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
