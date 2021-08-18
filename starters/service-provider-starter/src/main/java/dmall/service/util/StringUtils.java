package dmall.service.util;

import com.google.common.base.CaseFormat;
import org.springframework.lang.Nullable;

/**
 * @author walter
 */
public class StringUtils {

    public static boolean hasLength(@Nullable String str) {
        return (str != null && !str.isEmpty());
    }

    public static boolean hasText(@Nullable String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String lowerHyphenToUpperUnderscore(String str) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, str);
    }

    public static String lowerCamelToUpperUnderscore(String str) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
    }

    public static String upperCamelToUpperUnderscore(String str) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
    }
}
