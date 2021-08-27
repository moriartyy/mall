package mall.product.api.event;

import lombok.Getter;
import mall.common.event.Event;

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