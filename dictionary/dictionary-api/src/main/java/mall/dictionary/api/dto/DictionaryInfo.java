package mall.dictionary.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.common.dto.AuditableInfo;
import mall.common.enums.Activity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Walter
 */
@ApiModel(description = "DictionaryInfo")
@Getter
@Setter
@Accessors(chain = true)
public class DictionaryInfo extends AuditableInfo {

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

    @ApiModelProperty("Activity")
    private Activity activity;

    @ApiModelProperty("Items")
    private List<DictionaryItemInfo> items;

}
