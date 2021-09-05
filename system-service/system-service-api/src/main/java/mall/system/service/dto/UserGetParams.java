package mall.system.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author walter
 */
@Data
public class UserGetParams {
    @NotNull(message = "[id]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
}
