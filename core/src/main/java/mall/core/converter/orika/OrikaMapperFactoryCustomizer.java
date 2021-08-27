package mall.core.converter.orika;

import ma.glasnost.orika.MapperFactory;

/**
 * @author walter
 */
public interface OrikaMapperFactoryCustomizer {

    void customize(MapperFactory mapperFactory);
}
