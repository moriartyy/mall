package mall.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author walter
 */
@ApiModel(description = "Page Info")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class PageInfo<T> {

    @ApiModelProperty(value = "Current page index, start at 0")
    private Long pageIndex;

    @ApiModelProperty(value = "Page size")
    private Long pageSize;

    @ApiModelProperty(value = "Total pages number")
    private Long totalPages;

    @ApiModelProperty(value = "Total items number")
    private Long totalItems;

    @ApiModelProperty(value = "Current page items")
    private List<T> items;
}
