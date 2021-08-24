package mall.common.util;

import mall.common.model.EnumPlus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
public class EnumUtils {
    private static final Map<Class<?>, Tuple<Map<Integer, Enum<?>>, Map<String, Enum<?>>>> cache = new ConcurrentHashMap<>();

    public static <T extends Enum<T>> T getByName(Class<T> enumType, String name) {
        return Enum.valueOf(enumType, name);
    }

    public static <T extends Enum<T> & EnumPlus> T getByDisplayName(Class<T> enumType, String displayName) {
        Tuple<Map<Integer, Enum<?>>, Map<String, Enum<?>>> tuple = getMapTuple(enumType);
        return Optional.ofNullable(tuple.getV2().get(displayName))
                .map(enumType::cast)
                .orElseThrow(() -> new IllegalArgumentException(
                        enumType.getSimpleName() + "has no enum constant with displayName '" + displayName + "'."));
    }

    public static <T extends Enum<T> & EnumPlus> T getByValue(Class<T> enumType, Integer value) {
        Tuple<Map<Integer, Enum<?>>, Map<String, Enum<?>>> tuple = getMapTuple(enumType);
        return Optional.ofNullable(tuple.getV1().get(value))
                .map(enumType::cast)
                .orElseThrow(() -> new IllegalArgumentException(
                        enumType.getSimpleName() + "has no enum constant with value '" + value + "'."));
    }

    private static <T extends Enum<T> & EnumPlus> Tuple<Map<Integer, Enum<?>>, Map<String, Enum<?>>> getMapTuple(Class<T> enumType) {
        return cache.computeIfAbsent(enumType, e -> {
            Tuple<Map<Integer, Enum<?>>, Map<String, Enum<?>>> tuple = Tuple.of(new HashMap<>(), new HashMap<>());
            Arrays.stream(e.getEnumConstants())
                    .map(enumType::cast)
                    .forEach(t -> {
                        tuple.getV1().put(t.getValue(), t);
                        tuple.getV2().put(t.getDisplayName(), t);
                    });
            return tuple;
        });
    }
}
