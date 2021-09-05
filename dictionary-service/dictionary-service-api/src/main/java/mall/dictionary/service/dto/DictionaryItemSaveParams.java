package mall.dictionary.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import mall.common.dto.PersistableInfo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author walter
 */
@ApiModel(description = "DictionaryItemSaveParams", parent = PersistableInfo.class)
@Getter
@Setter
public class DictionaryItemSaveParams extends PersistableInfo {

    @NotBlank(message = "[Name]不能为空")
    @Size(max = 45, message = "[Name]编码长度不能超过45")
    @ApiModelProperty("Name")
    private String name;

    @NotBlank(message = "[Value]不能为空")
    @Size(max = 45, message = "[Value]编码长度不能超过45")
    @ApiModelProperty("Value")
    private String value;

    @NotNull(message = "[Sort]不能为空")
    @ApiModelProperty("Sort")
    private Short sort;

    @NotBlank(message = "[Link]不能为空")
    @Size(max = 500, message = "[Link]编码长度不能超过500")
    @ApiModelProperty("Link")
    private String link;

    @NotBlank(message = "[dictionaryCode]不能为空")
    @Size(max = 45, message = "[dictionaryCode]编码长度不能超过500")
    @ApiModelProperty("dictionaryCode")
    private String dictionaryCode;
}
