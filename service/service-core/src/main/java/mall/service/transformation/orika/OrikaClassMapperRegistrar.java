package mall.service.transformation.orika;

import ma.glasnost.orika.MapperFactory;

/**
 * @author walter
 */
public interface OrikaClassMapperRegistrar {

    void registerTo(MapperFactory mapperFactory);
}
