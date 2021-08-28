package mall.core.transformation.orika;

import ma.glasnost.orika.MapperFactory;

/**
 * @author walter
 */
public interface OrikaClassMapperRegistrar {

    void registerTo(MapperFactory mapperFactory);
}
