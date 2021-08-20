package mall.web.service.api.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @author walter
 */

@ApiModel(description = "API Result")
@Getter
@AllArgsConstructor
public class ApiResult<T> {

    @ApiModelProperty(value = "Status", dataType = "Integer", position = 0)
    @NotNull
    private ApiStatus status;
    @ApiModelProperty(value = "Message", position = 1)
    @NotNull
    private String message;
    @ApiModelProperty(value = "Data", position = 2)
    private T data;
    @ApiModelProperty(value = "Error", position = 3)
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
