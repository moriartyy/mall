package dmall.product.service.domain.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author walter
 */
@Getter
@Setter(AccessLevel.PACKAGE)
public class Product {
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
