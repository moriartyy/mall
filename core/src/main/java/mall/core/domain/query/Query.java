package mall.core.domain.query;

/**
 * @author walter
 */
public interface Query<T> {

    static <S> SimpleQuery.Builder<S> simple() {
        return SimpleQuery.builder();
    }
}
