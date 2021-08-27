package mall.common.util;

import mall.common.enums.EnumPlus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
public class EnumUtils {
    private static final Map<Class<?>, Tuple<Map<Integer, EnumPlus>, Map<String, EnumPlus>>> cache = new ConcurrentHashMap<>();

    public static <T extends Enum<T>> T getByName(Class<T> enumType, String name) {
        return Enum.valueOf(enumType, name);
    }

    public static <T extends EnumPlus> T getByTitle(Class<T> enumType, String title) {
        if (!enumType.isEnum()) {
            throw new IllegalArgumentException(enumType.getSimpleName() + " must be enum type.");
        }
        Tuple<Map<Integer, EnumPlus>, Map<String, EnumPlus>> tuple = getMapTuple(enumType);
        return Optional.ofNullable(tuple.getV2().get(title))
                .map(enumType::cast)
                .orElseThrow(() -> new IllegalArgumentException(
                        enumType.getSimpleName() + "has no enum constant with title '" + title + "'."));
    }

    public static <T extends EnumPlus> T getByValue(Class<T> enumType, Integer value) {
        if (!enumType.isEnum()) {
            throw new IllegalArgumentException(enumType.getSimpleName() + " must be enum type.");
        }
        Tuple<Map<Integer, EnumPlus>, Map<String, EnumPlus>> tuple = getMapTuple(enumType);
        return Optional.ofNullable(tuple.getV1().get(value))
                .map(enumType::cast)
                .orElseThrow(() -> new IllegalArgumentException(
                        enumType.getSimpleName() + "has no enum constant with value '" + value + "'."));
    }

    private static <T extends EnumPlus> Tuple<Map<Integer, EnumPlus>, Map<String, EnumPlus>> getMapTuple(Class<T> enumType) {
        return cache.computeIfAbsent(enumType, e -> {
            Tuple<Map<Integer, EnumPlus>, Map<String, EnumPlus>> tuple = Tuple.of(new HashMap<>(), new HashMap<>());
            Arrays.stream(e.getEnumConstants())
                    .map(enumType::cast)
                    .forEach(t -> {
                        tuple.getV1().put(t.getValue(), t);
                        tuple.getV2().put(t.getTitle(), t);
                    });
            return tuple;
        });
    }
}
