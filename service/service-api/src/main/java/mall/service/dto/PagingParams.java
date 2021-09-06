package mall.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author walter
 */
@Data
public abstract class PagingParams {

    @ApiModelProperty(value = "Request page index, start at 0")
    private Integer pageIndex;

    @ApiModelProperty(value = "Request page size")
    private Integer pageSize;
}
