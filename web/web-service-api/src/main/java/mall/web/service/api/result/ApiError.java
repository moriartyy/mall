package mall.web.service.api.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@ApiModel(description = "API Error")
@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApiError {
    UNKNOWN(200, "UNKNOWN");

    @ApiModelProperty(value = "Error Code")
    private final Integer code;
    @ApiModelProperty(value = "Error Message")
    private final String message;

}