package dmall.product.service.contract;


import dmall.product.service.contract.dto.ProductCreateParams;
import dmall.product.service.contract.dto.ProductGetParams;
import dmall.product.service.contract.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
