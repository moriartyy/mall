package mall.core.domain.query;

import lombok.extern.slf4j.Slf4j;
import mall.common.enums.EnumPlus;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.List;

import static mall.core.domain.query.Criteria.equalTo;
import static mall.core.domain.query.Criteria.in;

/**
 * orderBy=name^desc
 *
 * @author walter
 */
@Slf4j
public class QueryHelper {

    public static <T> PageQuery<T> toPageQuery(Object srcObj) {
        PageQuery.Builder<T> builder = QueryBuilders.page();
        Criteria criteria = Criteria.EMPTY;
        BeanWrapper beanWrapper = new BeanWrapperImpl(srcObj);
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        Integer pageIndex = null;
        Integer pageSize = null;
        for (PropertyDescriptor pd : pds) {

            String name = pd.getName();
            Object value = beanWrapper.getPropertyValue(name);

            if (value == null) {
                continue;
            }

            if ("orderBy".equals(name)) {
                String[] orderParts = ((String) value).split("^");
                if (orderParts.length == 2) {
                    builder.sort(Sort.of(orderParts[0], orderParts[1]));
                } else {
                    builder.sort(Sort.of(orderParts[0]));
                }
            } else if ("pageIndex".equals(name)) {
                builder.pageIndex((int) value);
            } else if ("pageSize".equals(name)) {
                builder.pageSize((int) value);
            } else if (value instanceof String || value instanceof Number) {
                criteria = criteria.and(equalTo(name, value));
            } else if (value instanceof List) {
                criteria = criteria.and(in(name, (List<?>) value));
            } else if (value instanceof EnumPlus) {
                criteria = criteria.and(equalTo(name, ((EnumPlus) value).getValue()));
            } else {
                log.warn("Unsupported property type {}, property {} ignored!", pd.getPropertyType(), name);
            }
        }
        return builder.build();
    }
}
