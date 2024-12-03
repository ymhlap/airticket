package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_permission")
public class RolePermission implements Serializable {
    @TableField("role_id")
    private Integer roleId;
    @TableField("permission_id")
    private Integer permissionId;
}
