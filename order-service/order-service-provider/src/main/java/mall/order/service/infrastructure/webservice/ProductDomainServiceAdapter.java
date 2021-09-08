package mall.order.service.infrastructure.webservice;

import lombok.RequiredArgsConstructor;
import mall.order.service.domain.product.Product;
import mall.order.service.domain.product.ProductDomainService;
import mall.product.service.dto.ProductGetParams;
import mall.product.service.dto.ProductInfo;
import mall.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductDomainServiceAdapter implements ProductDomainService {

    private final ProductService productService;

    @Override
    public Product findById(Integer id) {
        ProductInfo productInfo = productService.get(new ProductGetParams().setId(id));
        return convertTo(productInfo);
    }

    private Product convertTo(ProductInfo productInfo) {
        return null;
    }
}
