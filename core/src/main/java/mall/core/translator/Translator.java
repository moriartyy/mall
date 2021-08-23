package mall.core.translator;

/**
 * @author walter
 */
public interface Translator<A, B> {

    B forward(A a);

    A backward(B a);

}
