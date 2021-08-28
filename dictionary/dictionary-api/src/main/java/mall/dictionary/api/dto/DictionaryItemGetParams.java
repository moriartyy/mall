package mall.dictionary.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author walter
 */
@ApiModel(description = "DictionaryItemGetParams")
@Getter
@Setter
@Accessors(chain = true)
public class DictionaryItemGetParams {

    @ApiModelProperty("ID")
    private Integer id;
}
