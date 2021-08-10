package dmall.ddd.event;

import com.google.common.base.CaseFormat;

/**
 * @author walter
 */
public class EventUtils {

    public static String resolveEventType(Class<?> clazz) {
        return resolveEventType(clazz, true);
    }

    public static String resolveEventType(Class<?> clazz, boolean hasRedundantSuffix) {
        String eventType = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, clazz.getName());
        if (hasRedundantSuffix) {
            eventType = eventType.substring(0, eventType.lastIndexOf('_'));
        }
        return eventType;
    }
}
