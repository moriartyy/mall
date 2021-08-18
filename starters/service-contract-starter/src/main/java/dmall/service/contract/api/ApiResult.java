package dmall.service.contract.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author walter
 */

@ApiModel("API result model")
@Getter
@AllArgsConstructor
public class ApiResult<T> {

    @ApiModelProperty(value = "status")
    private ApiStatus status;
    @ApiModelProperty(value = "Message")
    private String message;
    @ApiModelProperty(value = "Data")
    private T data;
    @ApiModelProperty(value = "Error")
    private ApiError error;


    private ApiResult() {
        // for json deserialization only
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(ApiStatus.OK, ApiStatus.OK.getDescription(), data, null);
    }

    public static <T> ApiResult<T> fail(ApiStatus status) {
        return new ApiResult<>(status, status.getDescription(), null, null);
    }

    public static <T> ApiResult<T> fail(ApiStatus status, String message) {
        return new ApiResult<>(status, message, null, null);
    }

    public static <T> ApiResult<T> fail(ApiStatus status, String message, ApiError error) {
        return new ApiResult<>(status, message, null, error);
    }

    public static <T> ApiResult<T> fail(ApiStatus status, String message, T data) {
        return new ApiResult<>(status, message, data, null);
    }

    public static <T> ApiResult<T> fail(ApiStatus status, String message, T data, ApiError error) {
        return new ApiResult<>(status, message, data, error);
    }
}
