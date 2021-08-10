package dmall.product.service.application.event.handler;

import dmall.ddd.event.EventHandler;
import dmall.product.service.application.event.ProductSavedEvent;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class ProductCreatedHandler implements EventHandler<ProductSavedEvent> {

    @Override
    public void handle(ProductSavedEvent event) {
        throw new UnsupportedOperationException();
    }

}
