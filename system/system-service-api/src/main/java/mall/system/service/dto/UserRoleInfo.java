package mall.system.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Walter
 */
@ApiModel("UserRoleInfo")
@Getter
@Setter
@Accessors(chain = true)
public class UserRoleInfo {

    @NotNull(message = "[Integer]不能为空")
    @ApiModelProperty("Role ID")
    private Integer roleId;

    @NotBlank(message = "[name]不能为空")
    @Size(max = 45, message = "[name]编码长度不能超过45")
    @ApiModelProperty("Name")
    private String roleName;

}
