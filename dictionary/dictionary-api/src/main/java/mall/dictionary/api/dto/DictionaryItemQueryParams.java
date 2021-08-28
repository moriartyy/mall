package mall.dictionary.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author walter
 */

@ApiModel(description = "DictionaryItemInfo", parent = DictionaryItemInfo.class)
@Getter
@Setter
public class DictionaryItemQueryParams extends DictionaryItemInfo {

    @NotBlank(message = "[DictionaryCode]不能为空")
    @ApiModelProperty("DictionaryCode")
    private String dictionaryCode;

    @ApiModelProperty("ID")
    private Integer id;

    @Size(max = 45, message = "[Name]编码长度不能超过45")
    @ApiModelProperty("Name")
    private String name;

    @Size(max = 45, message = "[Value]编码长度不能超过45")
    @ApiModelProperty("Value")
    private String value;

}
