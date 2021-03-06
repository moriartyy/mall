package mall.product.service.domain.product;

import lombok.Getter;
import lombok.Setter;
import mall.service.domain.Entity;

/**
 * @author walter
 */
@Getter
@Setter
public class Product extends Entity<Integer> {
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
