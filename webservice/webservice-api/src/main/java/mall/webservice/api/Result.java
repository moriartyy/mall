package mall.webservice.api;

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
public class Result<T> {

    @ApiModelProperty(value = "Status", dataType = "Integer", position = 0)
    @NotNull
    private ResultStatus status;
    @ApiModelProperty(value = "Message", position = 1)
    @NotNull
    private String message;
    @ApiModelProperty(value = "Data", position = 2)
    private T data;
    @ApiModelProperty(value = "Error", position = 3)
    private Error error;


    private Result() {
        // for json deserialization only
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultStatus.OK, ResultStatus.OK.getDescription(), data, null);
    }

    public static <T> Result<T> fail(ResultStatus status) {
        return new Result<>(status, status.getDescription(), null, null);
    }

    public static <T> Result<T> fail(ResultStatus status, String message) {
        return new Result<>(status, message, null, null);
    }

    public static <T> Result<T> fail(ResultStatus status, String message, Error error) {
        return new Result<>(status, message, null, error);
    }

    public static <T> Result<T> fail(ResultStatus status, Error error) {
        return new Result<>(status, status.getDescription(), null, error);
    }

    public static <T> Result<T> fail(ResultStatus status, String message, T data) {
        return new Result<>(status, message, data, null);
    }

    public static <T> Result<T> fail(ResultStatus status, String message, T data, Error error) {
        return new Result<>(status, message, data, error);
    }
}
