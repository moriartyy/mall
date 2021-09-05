package mall.system.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author Walter
 */
@ApiModel("Role")
@Getter
@Setter
public class RoleInfo {


    @NotNull(message = "[id]不能为空")
    @ApiModelProperty("ID")
    private Integer id;

    @NotBlank(message = "[name]不能为空")
    @Size(max = 45, message = "[name]编码长度不能超过45")
    @ApiModelProperty("Name")
    private String name;

    @NotBlank(message = "[description]不能为空")
    @Size(max = 300, message = "[description]编码长度不能超过300")
    @ApiModelProperty("Description")
    private String description;

    @NotNull(message = "[createdAt]不能为空")
    @ApiModelProperty("Created at when")
    private LocalDateTime createdAt;

    @NotBlank(message = "[createdBy]不能为空")
    @Size(max = 45, message = "[createdBy]编码长度不能超过45")
    @ApiModelProperty("Created by who")
    private String createdBy;

    @NotNull(message = "[updatedAt]不能为空")
    @ApiModelProperty("Updated at when")
    private LocalDateTime updatedAt;

    @NotBlank(message = "[updatedBy]不能为空")
    @Size(max = 45, message = "[updatedBy]编码长度不能超过45")
    @ApiModelProperty("Updated by who")
    private String updatedBy;

}
