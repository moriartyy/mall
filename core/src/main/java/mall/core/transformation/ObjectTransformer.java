package mall.core.transformation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author walter
 */
public interface ObjectTransformer {

    <S, D> D map(S srcObj, Class<D> destClass);

    <S, D> void map(S srcObj, D destObj);

    default <S, D> List<D> mapList(List<S> src, Class<D> destClass) {
        return src.stream().map(e -> this.map(e, destClass)).collect(Collectors.toList());
    }
}
