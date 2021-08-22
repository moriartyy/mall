package mall.data.dictionary.service.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author walter
 */
@ApiModel
@Data
public class DictionaryGetParams {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("Code")
    private String code;
}
