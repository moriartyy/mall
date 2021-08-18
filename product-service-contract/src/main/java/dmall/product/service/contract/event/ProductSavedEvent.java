package dmall.product.service.contract.event;

import dmall.service.contract.event.Event;
import lombok.Getter;

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
