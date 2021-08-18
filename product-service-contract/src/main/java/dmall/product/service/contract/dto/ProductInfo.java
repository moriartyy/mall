package dmall.product.service.contract.dto;

import lombok.Data;

/**
 * @author walter
 */
@Data
public class ProductInfo {
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
