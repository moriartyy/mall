package mall.product.service.application;


import lombok.RequiredArgsConstructor;
import mall.product.service.application.assemblier.ProductAssembler;
import mall.product.service.domain.product.Product;
import mall.product.service.domain.product.ProductFactory;
import mall.product.service.domain.product.ProductRepository;
import mall.product.service.dto.ProductCreateParams;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductAssembler productAssembler;
//    private final TransactionalEventPublisher transactionalEventPublisher;

    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        Product product = this.productRepository.get(productGetParams.getId());
        return this.productAssembler.assemble(product);
    }

    @Override
    public Integer create(ProductCreateParams productCreateParams) {
        Product p = ProductFactory.newInstance()
                .withSN(productCreateParams.getSn())
                .withName(productCreateParams.getName())
                .create();

        this.productRepository.save(p);

//        ProductSavedEvent productSavedEvent = new ProductSavedEvent(p.getId(), p.getName());
//
//        this.transactionalEventPublisher.publish(productSavedEvent);

        return p.getId();
    }

}
