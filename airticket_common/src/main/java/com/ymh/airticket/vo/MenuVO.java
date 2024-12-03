package com.ymh.airticket.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO
 *
 * @author chemin
 * @since 2024/7/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("菜单VO")
public class MenuVO {

    @ApiModelProperty("菜单路径")
    private String path;

    @ApiModelProperty("菜单名称")
    private String title;

    @ApiModelProperty("菜单图标")
    private String icon;

    @ApiModelProperty("菜单路径")
    private String linkUrl;

    @ApiModelProperty("二级菜单")
    private List<MenuVO> children;
}
