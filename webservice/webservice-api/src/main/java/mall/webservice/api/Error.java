package mall.webservice.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author walter
 */
@ApiModel(description = "API Error")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    public static final Error UNKNOWN = new Error(null, "UNKNOWN");

    @ApiModelProperty(value = "Error Code")
    private Integer code;
    @ApiModelProperty(value = "Error Message")
    private String message;

    public static Error of(Integer code, String message) {
        return new Error(code, message);
    }

}
