package mall.service.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author walter
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = EnumPlusDeserializer.class)
public interface EnumPlus {

    @ApiModelProperty(value = "Title")
    String getTitle();

    @ApiModelProperty(value = "Value")
    Integer getValue();

}
