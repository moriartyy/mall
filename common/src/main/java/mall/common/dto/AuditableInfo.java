package mall.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author walter
 */
@Data
public class AuditableInfo extends PersistableInfo {
    /**
     * Created at when
     */
    @NotNull(message = "[CreatedAt]不能为空")
    @ApiModelProperty("Created at when")
    private LocalDateTime created_at;
    /**
     *
     */
    @NotBlank(message = "[CreatedBy]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("")
    private String created_by;
    /**
     * Updated at when
     */
    @NotNull(message = "[UpdatedAt]不能为空")
    @ApiModelProperty("Updated at when")
    private LocalDateTime updated_at;
    /**
     * Updated by who
     */
    @NotBlank(message = "[UpdatedBy]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Updated by who")
    private String updated_by;
}
