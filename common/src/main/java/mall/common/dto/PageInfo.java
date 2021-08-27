package mall.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author walter
 */
@ApiModel(description = "Page Info")
@Data
public class PageInfo<T> {

    @ApiModelProperty(value = "Current page number")
    private long pageNo;

    @ApiModelProperty(value = "Page size")
    private long pageSize;

    @ApiModelProperty(value = "Total pages number")
    private long totalPages;

    @ApiModelProperty(value = "Total items number")
    private long totalItems;

    @ApiModelProperty(value = "Current page items")
    private List<T> items;
}
