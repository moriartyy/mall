package mall.common.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import mall.common.util.EnumUtils;

import java.io.IOException;

/**
 * @author walter
 */
public class EnumPlusDeserializer<T extends Enum<T> & EnumPlus> extends JsonDeserializer<T> {

    private final Class<T> enumType;

    public EnumPlusDeserializer(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public T deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode jsonNode = context.readTree(parser);
        return EnumUtils.getByValue(enumType, jsonNode.get("value").asInt());
    }
}
