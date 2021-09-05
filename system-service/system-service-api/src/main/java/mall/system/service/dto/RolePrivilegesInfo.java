package mall.system.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Walter
 */
@ApiModel("")
@Getter
@Setter
public class RolePrivilegesInfo {


    @NotNull(message = "[roleId]不能为空")
    @ApiModelProperty("")
    private Integer roleId;

    @NotNull(message = "[privilegeId]不能为空")
    @ApiModelProperty("")
    private Integer privilegeId;

    @NotBlank(message = "[privilegeCode]不能为空")
    @Size(max = 45, message = "[privilegeCode]编码长度不能超过45")
    @ApiModelProperty("Privilege Code")
    private String privilegeCode;

}
