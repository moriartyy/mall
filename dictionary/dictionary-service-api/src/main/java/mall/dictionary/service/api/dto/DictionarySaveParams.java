package mall.dictionary.service.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author walter
 */
@ApiModel(description = "DictionarySaveParams")
public class DictionarySaveParams {

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Integer id;
    /**
     * Code
     */
    @NotBlank(message = "[Code]不能为空")
    @Size(max = 45, message = "[Code]编码长度不能超过45")
    @ApiModelProperty("Code")
    private String code;
    /**
     * Description
     */
    @Size(max = 300, message = "Description编码长度不能超过300")
    @ApiModelProperty("Description")
    private String description;

    @ApiModelProperty("Items")
    private List<DictionaryItemInfo> items;

    @NotBlank(message = "[Activity]不能为空")
    @Size(min = 0, max = 1)
    @ApiModelProperty("Activity")
    private Integer activity;

}
