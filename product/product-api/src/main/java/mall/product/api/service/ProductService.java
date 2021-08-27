package mall.product.api.service;


import mall.product.api.dto.ProductCreateParams;
import mall.product.api.dto.ProductGetParams;
import mall.product.api.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
