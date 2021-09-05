package mall.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @author walter
 */
@ApiModel(description = "Page Info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {

    @ApiModelProperty(value = "Current page index, start at 0")
    private long pageIndex;

    @ApiModelProperty(value = "Page size")
    private long pageSize;

    @ApiModelProperty(value = "Total pages number")
    private long totalPages;

    @ApiModelProperty(value = "Total items number")
    private long totalItems;

    @ApiModelProperty(value = "Current page items")
    private List<T> items;
}
