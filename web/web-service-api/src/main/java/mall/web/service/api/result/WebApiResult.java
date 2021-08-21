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
public class WebApiResult<T> {

    @ApiModelProperty(value = "Status", dataType = "Integer", position = 0)
    @NotNull
    private WebApiStatus status;
    @ApiModelProperty(value = "Message", position = 1)
    @NotNull
    private String message;
    @ApiModelProperty(value = "Data", position = 2)
    private T data;
    @ApiModelProperty(value = "Error", position = 3)
    private WebApiError error;


    private WebApiResult() {
        // for json deserialization only
    }

    public static <T> WebApiResult<T> success(T data) {
        return new WebApiResult<>(WebApiStatus.OK, WebApiStatus.OK.getDescription(), data, null);
    }

    public static <T> WebApiResult<T> fail(WebApiStatus status) {
        return new WebApiResult<>(status, status.getDescription(), null, null);
    }

    public static <T> WebApiResult<T> fail(WebApiStatus status, String message) {
        return new WebApiResult<>(status, message, null, null);
    }

    public static <T> WebApiResult<T> fail(WebApiStatus status, String message, WebApiError error) {
        return new WebApiResult<>(status, message, null, error);
    }

    public static <T> WebApiResult<T> fail(WebApiStatus status, String message, T data) {
        return new WebApiResult<>(status, message, data, null);
    }

    public static <T> WebApiResult<T> fail(WebApiStatus status, String message, T data, WebApiError error) {
        return new WebApiResult<>(status, message, data, error);
    }
}
