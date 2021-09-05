package mall.product.service.service;


import mall.product.service.dto.ProductCreateParams;
import mall.product.service.dto.ProductGetParams;
import mall.product.service.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
