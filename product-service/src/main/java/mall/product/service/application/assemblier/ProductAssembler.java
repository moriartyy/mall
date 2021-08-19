package mall.product.service.application.assemblier;

import lombok.RequiredArgsConstructor;
import mall.product.service.contract.dto.ProductInfo;
import mall.product.service.domain.product.Product;
import mall.product.service.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductAssembler {

    private final ProductRepository productRepository;

    public ProductInfo assemble(Product product) {
        ProductInfo pi = new ProductInfo();
        pi.setId(product.getId());
        return pi;
    }
}
