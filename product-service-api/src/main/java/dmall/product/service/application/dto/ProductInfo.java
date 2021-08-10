package dmall.product.service.application.dto;

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
