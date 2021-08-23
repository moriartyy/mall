package mall.core.domain.query;

import mall.core.util.ClassUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */

@SuppressWarnings("unchecked")
@Component
public class QueryResolvingService implements ApplicationContextAware, InitializingBean {
    @SuppressWarnings("rawtypes")
    private final Map<Class, QueryResolver> resolverMap = new ConcurrentHashMap<>();
    private ApplicationContext applicationContext;

    @SuppressWarnings("rawtypes")
    public <T> Query resolve(T source) {
        QueryResolver resolver = resolverMap.getOrDefault(source.getClass(), DefaultQueryResolver.INSTANCE);
        return resolver.resolve(source);
    }

    @Override
    public void afterPropertiesSet() {
        applicationContext.getBeansOfType(QueryResolver.class).values()
                .forEach(r -> resolverMap.put(ClassUtils.resolveGenericType(r.getClass()), r));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
