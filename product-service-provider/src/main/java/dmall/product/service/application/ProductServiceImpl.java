package dmall.product.service.application;


import dmall.product.service.application.assemblier.ProductAssembler;
import dmall.product.service.application.dto.ProductCreateParams;
import dmall.product.service.application.dto.ProductGetParams;
import dmall.product.service.application.dto.ProductInfo;
import dmall.ddd.event.TransactionalEventPublisher;
import dmall.product.service.application.event.ProductSavedEvent;
import dmall.product.service.domain.product.Product;
import dmall.product.service.domain.product.ProductFactory;
import dmall.product.service.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
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
    private final TransactionalEventPublisher transactionalEventPublisher;

    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        Product product = this.productRepository.getById(productGetParams.getId());
        return this.productAssembler.assemble(product);
    }

    @Override
    public Integer create(ProductCreateParams productCreateParams) {
        Product p = ProductFactory.newInstance()
                .withSN(productCreateParams.getSn())
                .withName(productCreateParams.getName())
                .create();

        this.productRepository.save(p);

        ProductSavedEvent productSavedEvent = new ProductSavedEvent(p.getId(), p.getName());

        this.transactionalEventPublisher.publish(productSavedEvent);

        return p.getId();
    }

}
