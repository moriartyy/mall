package mall.product.service.contract;


import mall.product.service.contract.dto.ProductCreateParams;
import mall.product.service.contract.dto.ProductGetParams;
import mall.product.service.contract.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
