package mall.system.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author walter
 */
@Getter
@Setter
public class UserSaveParams {

    @ApiModelProperty("ID")
    private Integer id;

    @NotBlank(message = "[name]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Name")
    private String name;

    @NotBlank(message = "[realName]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Real Name")
    private String realName;

    @NotNull(message = "[activity]不能为空")
    @ApiModelProperty("Activity")
    private Integer activity;
}
