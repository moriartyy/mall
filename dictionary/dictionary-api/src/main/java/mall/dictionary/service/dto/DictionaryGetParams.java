package mall.dictionary.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author walter
 */
@ApiModel(description = "DictionaryGetParams")
@Getter
@Setter
@Accessors(chain = true)
public class DictionaryGetParams {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("Code")
    private String code;
}
