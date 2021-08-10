package dmall.product.service.application;


import dmall.product.service.application.dto.ProductCreateParams;
import dmall.product.service.application.dto.ProductGetParams;
import dmall.product.service.application.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
