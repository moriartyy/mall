package mall.core.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

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

    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    public static String[] getNullProperties(Object src) {
        BeanWrapper bw = new BeanWrapperImpl(src);
        return Arrays.stream(bw.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(n -> !StringUtils.isEmpty(bw.getPropertyValue(n)))
                .toArray(String[]::new);
    }
}
