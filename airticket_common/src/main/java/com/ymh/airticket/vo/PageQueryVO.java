package com.ymh.airticket.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author chemin
 * @since 2024/7/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页查询数据")
public class PageQueryVO {

    @ApiModelProperty("当前页码")
    private Integer currentPage;

    @ApiModelProperty("每页记录数")
    private Integer pageSize;

    @ApiModelProperty("查询条件")
    private String queryString;

}
