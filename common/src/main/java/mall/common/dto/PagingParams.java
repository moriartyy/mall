package mall.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author walter
 */
@Data
public abstract class PagingParams {

    @ApiModelProperty(value = "Request page number")
    private long pageNo;

    @ApiModelProperty(value = "Request page size")
    private long pageSize;
}
