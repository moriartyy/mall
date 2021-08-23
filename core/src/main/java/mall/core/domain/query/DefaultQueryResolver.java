package mall.core.domain.query;

/**
 * @author walter
 */
public class DefaultQueryResolver implements QueryResolver<Object> {

    public static final DefaultQueryResolver INSTANCE = new DefaultQueryResolver();

    @Override
    public Query resolve(Object source) {
        return null;
    }
}
