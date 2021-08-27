package mall.core.converter;

/**
 * @author walter
 */
public interface ObjectConverter {

    <A, B> B convert(A a, Class<B> bClass);
}
