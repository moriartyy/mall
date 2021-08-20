package mall.product.service.api;


import mall.product.service.api.dto.ProductCreateParams;
import mall.product.service.api.dto.ProductGetParams;
import mall.product.service.api.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
