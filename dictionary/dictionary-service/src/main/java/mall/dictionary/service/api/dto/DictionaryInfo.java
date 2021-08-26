package mall.dictionary.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author Walter
 */
@Data
public class DictionaryInfo {

    /**
     * ID
     */
    @NotNull(message = "[ID]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
    /**
     * Code
     */
    @NotBlank(message = "[Code]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Code")
    private String code;
    /**
     * Description
     */
    @NotBlank(message = "[Description]不能为空")
    @Size(max = 300, message = "编码长度不能超过300")
    @ApiModelProperty("Description")
    private String description;
    /**
     * Created at when
     */
    @NotNull(message = "[Created at when]不能为空")
    @ApiModelProperty("Created at when")
    private LocalDateTime created_at;
    /**
     *
     */
    @NotBlank(message = "[]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("")
    private String created_by;
    /**
     * Updated at when
     */
    @NotNull(message = "[Updated at when]不能为空")
    @ApiModelProperty("Updated at when")
    private LocalDateTime updated_at;
    /**
     * Updated by who
     */
    @NotBlank(message = "[Updated by who]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Updated by who")
    private String updated_by;

}
