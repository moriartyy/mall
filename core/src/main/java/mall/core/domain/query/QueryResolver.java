package mall.core.domain.query;

/**
 * @author walter
 */
public interface QueryResolver<T> {

    Query resolve(T source);
}
