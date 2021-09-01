package mall.core.config;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import mall.common.enums.EnumPlus;
import mall.common.util.EnumUtils;
import mall.core.transformation.ObjectTransformer;
import mall.core.transformation.orika.OrikaObjectTransformer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@Configuration
public class OrikaConfig {

    @Bean
    @ConditionalOnMissingBean
    public ObjectTransformer objectTransformer() {
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .mapNulls(false)
                .build();
        mapperFactory.getConverterFactory().registerConverter(new EnumPlusConverter<>());
        return new OrikaObjectTransformer(mapperFactory);
    }

    static class EnumPlusConverter<T extends EnumPlus> extends BidirectionalConverter<T, Integer> {

        @Override
        public Integer convertTo(T t, Type<Integer> type, MappingContext mappingContext) {
            return t.getValue();
        }

        @Override
        public T convertFrom(Integer integer, Type<T> type, MappingContext mappingContext) {
            return EnumUtils.getByValue(type.getRawType(), integer);
        }

        @Override
        public boolean canConvert(Type<?> sourceType, Type<?> destinationType) {
            return ((sourceType.getRawType() == Integer.class) & (EnumPlus.class.isAssignableFrom(destinationType.getRawType())))
                    || ((destinationType.getRawType() == Integer.class) & (EnumPlus.class.isAssignableFrom(sourceType.getRawType())));
        }
    }
}
