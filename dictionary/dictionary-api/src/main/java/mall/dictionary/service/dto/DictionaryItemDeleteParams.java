package mall.dictionary.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author walter
 */
@Getter
@Setter
public class DictionaryItemDeleteParams {
    @NotNull(message = "[ID]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
}
