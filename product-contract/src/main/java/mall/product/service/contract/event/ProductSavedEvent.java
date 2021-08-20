package mall.product.service.contract.event;

import lombok.Getter;
import mall.contract.common.event.Event;

/**
 * @author walter
 */
@Getter
public class ProductSavedEvent extends Event {
    private Integer productId;
    private String productName;

    public ProductSavedEvent(Integer productId, String productName) {
        super(true);
        this.productId = productId;
        this.productName = productName;
    }

    private ProductSavedEvent() {
        super(false);
    }
}