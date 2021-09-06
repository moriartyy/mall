package mall.product.service.event;

import lombok.Getter;
import mall.service.event.Event;

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
