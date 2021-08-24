package mall.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author walter
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = EnumPlusDeserializer.class)
public interface EnumPlus {

    String getDisplayName();

    Integer getValue();

}
