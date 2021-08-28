package mall.core.util;

import mall.common.util.Tuple;
import org.springframework.core.ResolvableType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
public class ClassUtils {

    private static final Map<Tuple<Class<?>, Class<?>>, Class<?>[]> CACHE = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> Class<T> resolveGenericType(Class<?> sourceClass, int index) {
        Class<?>[] generics = resolveGenericTypes(sourceClass);

        if (index >= generics.length) {
            throw new IllegalArgumentException(sourceClass.getName() + " has no generic type at index " + index);
        }

        return (Class<T>) generics[index];
    }

    public static <T> Class<T> resolveGenericType(Class<?> sourceClass) {
        return resolveGenericType(sourceClass, 0);
    }

    public static Class<?> resolveGenericType(Class<?> sourceClass, Class<?> originalClass, int index) {
        return resolveGenericTypes(sourceClass, originalClass)[index];
    }

    public static Class<?>[] resolveGenericTypes(Class<?> sourceClass) {
        return CACHE.computeIfAbsent(Tuple.of(sourceClass, Object.class), tuple -> {
            ResolvableType t = ResolvableType.forClass(sourceClass);
            do {
                if (t.hasGenerics()) {
                    return t.resolveGenerics();
                } else {
                    for (ResolvableType i : t.getInterfaces()) {
                        if (i.hasGenerics()) {
                            return i.resolveGenerics();
                        }
                    }
                }
            } while ((t = t.getSuperType()) != ResolvableType.NONE);
            return new Class[0];
        });
    }

    public static Class<?>[] resolveGenericTypes(Class<?> sourceClass, Class<?> originalClass) {
        return CACHE.computeIfAbsent(Tuple.of(sourceClass, originalClass), tuple -> {
            ResolvableType t = ResolvableType.forClass(sourceClass);
            if (originalClass.isInterface()) {
                do {
                    for (ResolvableType i : t.getInterfaces()) {
                        if (i.getRawClass() == originalClass) {
                            return i.resolveGenerics();
                        }
                    }
                } while ((t = t.getSuperType()) != ResolvableType.NONE);
            } else {
                do {
                    if (t.getRawClass() == originalClass) {
                        return t.resolveGenerics();
                    }
                } while ((t = t.getSuperType()) != ResolvableType.NONE);
            }
            return new Class[0];
        });
    }

}
