package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_menu")
public class RoleMenu {
    @TableField("role_id")
    private Integer roleId;
    @TableField("menu_id")
    private Integer menuId;
}
