package mall.data.dictionary.service.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Walter
 */
@Data
public class DictionaryItemInfo {

    /**
     * ID
     */
    @NotNull(message = "[ID]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
    /**
     * DictionaryID
     */
    @NotNull(message = "[DictionaryID]不能为空")
    @ApiModelProperty("DictionaryID")
    private Integer dictionary_id;
    /**
     * TItle
     */
    @NotBlank(message = "[TItle]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("TItle")
    private String title;
    /**
     * Value
     */
    @NotBlank(message = "[Value]不能为空")
    @Size(max = 45, message = "编码长度不能超过45")
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
    @Size(max = 500, message = "编码长度不能超过500")
    @ApiModelProperty("Link")
    private String link;

}
