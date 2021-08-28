package mall.core.translator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author walter
 */
public interface Translator<S, D> {

    D forward(S s);

    default List<D> forward(List<S> sList) {
        return sList.stream().map(this::forward).collect(Collectors.toList());
    }

    S backward(D a);


}
