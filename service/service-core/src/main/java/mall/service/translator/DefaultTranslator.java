package mall.service.translator;

import lombok.Getter;
import mall.service.util.ObjectUtils;
import org.springframework.core.ResolvableType;

/**
 * @author walter
 */
@Getter
public class DefaultTranslator<A, B> implements Translator<A, B> {

    private final Class<A> classA;
    private final Class<B> classB;

    @SuppressWarnings("unchecked")
    public DefaultTranslator() {
        Class<?>[] generics = ResolvableType.forClass(getClass()).resolveGenerics();
        this.classA = (Class<A>) generics[0];
        this.classB = (Class<B>) generics[1];
    }

    @Override
    public B forward(A a) {
        return ObjectUtils.createInstanceOf(classB, a);
    }

    @Override
    public A backward(B b) {
        return ObjectUtils.createInstanceOf(classA, b);
    }
}
