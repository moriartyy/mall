package mall.product.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author walter
 */
@Data
@Accessors(chain = true)
public class ProductGetParams {
    private Integer id;
}
