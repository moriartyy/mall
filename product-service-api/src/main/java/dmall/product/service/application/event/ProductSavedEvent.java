package dmall.product.service.application.event;

import dmall.ddd.event.Event;
import lombok.Getter;

/**
 * @author walter
 */
@Getter
public class ProductSavedEvent extends Event<ProductSavedEvent> {

    private final Integer productId;
    private final String productName;

    public ProductSavedEvent(Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}
