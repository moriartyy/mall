package mall.web.service.api.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mall.common.model.Error;

/**
 * @author walter
 */
@ApiModel(description = "API Error")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    public static final ApiError UNKNOWN = new ApiError(null, "UNKNOWN");

    @ApiModelProperty(value = "Error Code")
    private Integer code;
    @ApiModelProperty(value = "Error Message")
    private String message;

    public static ApiError from(Error error) {
        return new ApiError(error.getCode(), error.getMessage());
    }

}
