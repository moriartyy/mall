package mall.core.util;

import org.springframework.core.ResolvableType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
public class ClassUtils {

    private static final Map<Class<?>, Class<?>[]> CACHE = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> Class<T> resolveGenericType(Class<?> clazz, int index) {
        Class<?>[] generics = CACHE.computeIfAbsent(clazz, c -> {
            ResolvableType t = ResolvableType.forClass(clazz);
            if (t.hasGenerics()) {
                return t.resolveGenerics();
            }
            ResolvableType st = t.getSuperType();
            if (st.hasGenerics()) {
                return st.resolveGenerics();
            }
            ResolvableType[] ifs = t.getInterfaces();
            for (ResolvableType i : ifs) {
                Class<?>[] gs = i.resolveGenerics();
                if (gs.length > index) {
                    return gs;
                }
            }
            return new Class<?>[0];
        });

        if (index >= generics.length) {
            throw new IllegalArgumentException(clazz.getName() + " has no generic type at index " + index);
        }

        return (Class<T>) generics[index];
    }

    public static <T> Class<T> resolveGenericType(Class<?> clazz) {
        return resolveGenericType(clazz, 0);
    }
}
