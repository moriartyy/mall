package mall.service.domain.query;

import lombok.extern.slf4j.Slf4j;
import mall.service.enums.EnumPlus;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.time.temporal.Temporal;
import java.util.List;

import static mall.service.domain.query.Criteria.*;

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
            } else if (value instanceof String) {
                String valueStr = (String) value;
                if (valueStr.startsWith(">")) {
                    if (valueStr.startsWith("=", 1)) {
                        criteria = criteria.and(greaterThanOrEqualTo(name, valueStr.substring(2)));
                    } else {
                        criteria = criteria.and(greaterThen(name, valueStr.substring(1)));
                    }
                } else if (valueStr.startsWith("<")) {
                    if (valueStr.startsWith("=", 1)) {
                        criteria = criteria.and(lessThanOrEqualTo(name, valueStr.substring(2)));
                    } else {
                        criteria = criteria.and(lessThan(name, valueStr.substring(1)));
                    }
                } else {
                    criteria = criteria.and(equalTo(name, value));
                }
            } else if (value instanceof Number) {
                criteria = criteria.and(equalTo(name, value));
            } else if (value instanceof Temporal) {
                criteria = criteria.and(equalTo(name, value));
            } else if (value instanceof List) {
                criteria = criteria.and(in(name, (List<?>) value));
            } else if (value instanceof EnumPlus) {
                criteria = criteria.and(equalTo(name, ((EnumPlus) value).getValue()));
            } else {
                log.warn("Unsupported property type {}, property {} ignored!", pd.getPropertyType(), name);
            }

        }
        return builder.criteria(criteria).build();
    }
}
