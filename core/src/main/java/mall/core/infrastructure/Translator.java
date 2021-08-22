package mall.core.infrastructure;

/**
 * @author walter
 */
public interface Translator<A, B> {

    B forward(A a);

    A backward(B a);

}
