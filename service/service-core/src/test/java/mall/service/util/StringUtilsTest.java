package mall.service.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */
class StringUtilsTest {

    @Test
    void padLeft() {
        assertEquals("  1", StringUtils.padLeft(1, 3, ' '));
        assertEquals("  1", StringUtils.padLeft("1", 3, ' '));
        assertEquals(" 12", StringUtils.padLeft(12, 3, ' '));
        assertEquals("012", StringUtils.padLeft(12, 3, '0'));
    }
}
