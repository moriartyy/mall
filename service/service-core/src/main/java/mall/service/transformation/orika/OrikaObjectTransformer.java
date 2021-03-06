package mall.service.transformation.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import mall.service.transformation.ObjectTransformer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author walter
 */
public class OrikaObjectTransformer implements ObjectTransformer, InitializingBean, ApplicationContextAware {

    private MapperFacade mapperFacade;
    private final MapperFactory mapperFactory;
    private ApplicationContext applicationContext;

    public OrikaObjectTransformer() {
        this(new DefaultMapperFactory.Builder().mapNulls(false).build());
    }

    public OrikaObjectTransformer(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <S, D> D map(S srcObj, Class<D> destClass) {
        return mapperFacade.map(srcObj, destClass);
    }

    @Override
    public <S, D> void map(S srcObj, D destObj) {
        mapperFacade.map(srcObj, destObj);
        ;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.applicationContext.getBeansOfType(OrikaClassMapperRegistrar.class)
                .values()
                .forEach(customizer -> {
                    customizer.registerTo(this.mapperFactory);
                });
        this.mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
