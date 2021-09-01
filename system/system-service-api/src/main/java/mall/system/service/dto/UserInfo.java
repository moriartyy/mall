package mall.system.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Walter
 */
@ApiModel("UserInfo")
@Getter
@Setter
public class UserInfo {

    @NotNull(message = "[id]不能为空")
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

    @NotNull(message = "[createdAt]不能为空")
    @ApiModelProperty("Created at when")
    private LocalDateTime createdAt;

    @NotBlank(message = "[createdBy]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Created by who")
    private String createdBy;

    @NotNull(message = "[updatedAt]不能为空")
    @ApiModelProperty("Updated at when")
    private LocalDateTime updatedAt;

    @NotBlank(message = "[updatedBy]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Updated by who")
    private String updatedBy;

    @ApiModelProperty("User Roles")
    private List<UserRoleInfo> roles;

}
