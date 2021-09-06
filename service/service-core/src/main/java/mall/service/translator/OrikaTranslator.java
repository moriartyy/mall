package mall.service.translator;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;

/**
 * @author walter
 */
public class OrikaTranslator<A, B> extends DefaultTranslator<A, B> {

    private final MapperFacade mapperFacade;

    public OrikaTranslator(MapperFactory mapperFactory) {
        customize(mapperFactory);
        this.mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public B forward(A a) {
        return this.mapperFacade.map(a, getClassB());
    }

    @Override
    public A backward(B a) {
        return this.mapperFacade.map(a, getClassA());
    }

    public void customize(MapperFactory mapperFactory) {

    }
}
