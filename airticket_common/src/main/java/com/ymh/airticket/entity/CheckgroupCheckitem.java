package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("checkgroup_checkitem")
public class CheckgroupCheckitem {

    @TableField("checkgroup_id")
    private Integer checkgroupId;
    @TableField("checkitem_id")
    private Integer checkitemId;
}
