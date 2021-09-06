package mall.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mall.service.enums.EnumPlus;
import mall.service.util.JsonUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */
class EnumPlusTest {

    @Test
    void test() {
        String s = JsonUtils.serializeToString(Color.RED);
        System.out.println(s);
        Color c = JsonUtils.deserializeFromString(s, Color.class);
        assertEquals(Color.RED, c);
    }

    @Getter
    @RequiredArgsConstructor
    enum Color implements EnumPlus {
        RED("red", 1), WHITE("white", 2);

        private final String title;
        private final Integer value;
    }

}
