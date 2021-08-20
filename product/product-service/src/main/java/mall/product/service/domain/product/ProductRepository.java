package mall.product.service.domain.product;

import mall.core.domain.Repository;

/**
 * @author walter
 */
public interface ProductRepository extends Repository {

    Product getById(Integer id);

    Product getBySN(String sn);

    void save(Product product);

}
