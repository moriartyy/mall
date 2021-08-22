package mall.product.service.domain.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mall.core.domain.Entity;

/**
 * @author walter
 */
@Getter
@Setter(AccessLevel.PACKAGE)
public class Product implements Entity<Integer> {
    /**
     * ID
     */
    private Integer id;
    /**
     * Serial Number
     */
    private String sn;
    /**
     * Name
     */
    private String name;
}
