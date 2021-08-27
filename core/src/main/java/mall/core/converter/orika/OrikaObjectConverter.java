package mall.core.converter.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import mall.core.converter.ObjectConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class OrikaObjectConverter implements ObjectConverter, InitializingBean, ApplicationContextAware {

    private MapperFacade mapperFacade;
    private final MapperFactory mapperFactory;
    private ApplicationContext applicationContext;

    public OrikaObjectConverter(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <S, D> D convert(S s, Class<D> destinationClass) {
        return mapperFacade.map(s, destinationClass);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.applicationContext.getBeansOfType(OrikaMapperFactoryCustomizer.class)
                .values()
                .forEach(customizer -> {
                    customizer.customize(this.mapperFactory);
                });
        this.mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
