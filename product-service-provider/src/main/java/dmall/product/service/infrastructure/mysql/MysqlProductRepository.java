package dmall.product.service.infrastructure.mysql;

import dmall.product.service.domain.product.Product;
import dmall.product.service.domain.product.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Getter
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MysqlProductRepository implements ProductRepository {

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Product getBySN(String sn) {
        return null;
    }

    @Override
    public void save(Product product) {

    }
}
