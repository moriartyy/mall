package mall.dictionary.service;

import com.google.common.collect.ImmutableList;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import mall.common.enums.Activity;
import mall.common.enums.EnumPlus;
import mall.common.util.EnumUtils;
import mall.common.util.JsonUtils;
import mall.dictionary.service.api.dto.DictionaryInfo;
import mall.dictionary.service.api.dto.DictionaryItemInfo;
import mall.dictionary.service.domain.Dictionary;
import org.junit.jupiter.api.Test;

/**
 * @author walter
 */
class DictionaryInfoTest {


    @Test
    void testMap() {
        DictionaryInfo source = new DictionaryInfo()
                .setId(1)
                .setCode("123")
                .setDescription("hello")
                .setItems(ImmutableList.of(new DictionaryItemInfo().setName("good").setValue("v")))
                .setActivity(Activity.ENABLED);

        Dictionary target = new Dictionary();
        System.out.println(JsonUtils.serializeToString(source));
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(new MyConverter<>());
        mapperFactory.getMapperFacade().map(source, target);

        System.out.println(JsonUtils.serializeToString(target));

    }

    static class MyConverter<T extends EnumPlus> extends BidirectionalConverter<T, Integer> {

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