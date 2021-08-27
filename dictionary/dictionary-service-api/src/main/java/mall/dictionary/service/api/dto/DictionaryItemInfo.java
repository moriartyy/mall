package mall.dictionary.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Walter
 */
@Data
@Accessors(chain = true)
public class DictionaryItemInfo {

    /**
     * Name
     */
    @NotBlank(message = "[Name]不能为空")
    @Size(max = 45, message = "[Name]编码长度不能超过45")
    @ApiModelProperty("Name")
    private String name;
    /**
     * Value
     */
    @NotBlank(message = "[Value]不能为空")
    @Size(max = 45, message = "[Value]编码长度不能超过45")
    @ApiModelProperty("Value")
    private String value;
    /**
     * Sort
     */
    @NotNull(message = "[Sort]不能为空")
    @ApiModelProperty("Sort")
    private Short sort;
    /**
     * Link
     */
    @NotBlank(message = "[Link]不能为空")
    @Size(max = 500, message = "[Link]编码长度不能超过500")
    @ApiModelProperty("Link")
    private String link;

}
