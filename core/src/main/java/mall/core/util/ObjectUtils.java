package mall.core.util;

import org.springframework.beans.BeanUtils;

/**
 * @author walter
 */
public class ObjectUtils {

    public static <T> T createInstanceOf(Class<T> clazz) {
        return BeanUtils.instantiateClass(clazz);
    }

    public static <T> T createInstanceOf(Class<T> clazz, Object properties) {
        T instance = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(properties, instance);
        return instance;
    }

    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    public static void copyProperties(Object source, Object target, Class<?> editable) {
        BeanUtils.copyProperties(source, target, editable);
    }
}
