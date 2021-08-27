package mall.dictionary.service.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import mall.common.dto.DataChangeInfo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Walter
 */
@ApiModel(description = "DictionaryInfo")
@Data
public class DictionaryInfo extends DataChangeInfo {

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

    @ApiModelProperty("Items")
    private List<DictionaryItemInfo> items;

}
