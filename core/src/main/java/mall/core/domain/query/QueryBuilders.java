package mall.core.domain.query;

/**
 * @author walter
 */
public class QueryBuilders {

    public static <S> PageQuery.Builder<S> page() {
        return PageQuery.builder();
    }

    public static <S> SimpleQuery.Builder<S> simple() {
        return SimpleQuery.builder();
    }
}
