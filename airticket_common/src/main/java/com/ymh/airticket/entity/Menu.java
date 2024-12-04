package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//菜单
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu")
public class Menu implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("linkUrl")
    private String linkUrl;
    @TableField("path")
    private String path;
    @TableField("priority")
    private Integer priority;
    @TableField("icon")
    private String icon;
    @TableField("description")
    private String description;
    @TableField("parentMenuId")
    private Integer parentMenuId;
    @TableField("level")
    private Integer level;

    public Menu(String name, String linkUrl, String path) {
        this.name = name;
        this.linkUrl = linkUrl;
        this.path = path;
    }
}
