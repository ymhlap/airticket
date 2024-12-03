package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("setmeal_checkgroup")
public class SetmealCheckgroup {
    @TableField("setmeal_id")
    private Integer setmealId;
    @TableField("checkgroup_id")
    private Integer checkgroupId;
}
