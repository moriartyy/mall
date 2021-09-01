package mall.core.util;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author walter
 */
public class CollectionUtils {

    public static <S, D> List<D> map(List<S> src, Function<S, D> converter) {
        return src.stream().map(converter).collect(Collectors.toList());
    }

    public static <S, D> Set<D> map(Set<S> src, Function<S, D> converter) {
        return src.stream().map(converter).collect(Collectors.toSet());
    }

}
