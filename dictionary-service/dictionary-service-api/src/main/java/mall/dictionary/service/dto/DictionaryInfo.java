package mall.dictionary.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.common.dto.AuditableInfo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Walter
 */
@ApiModel(description = "DictionaryInfo")
@Getter
@Setter
@Accessors(chain = true)
public class DictionaryInfo extends AuditableInfo {

    @NotBlank(message = "[Code]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Code")
    private String code;

    @NotBlank(message = "[Description]不能为空")
    @Size(max = 300, message = "编码长度不能超过300")
    @ApiModelProperty("Description")
    private String description;

    @NotNull(message = "[Activity]不能为空")
    @ApiModelProperty("Activity")
    private Integer activity;

    @NotNull(message = "[OrderType]不能为空")
    @ApiModelProperty("OrderType")
    private Integer orderType;

}
