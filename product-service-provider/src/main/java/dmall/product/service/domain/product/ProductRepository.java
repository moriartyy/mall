package dmall.product.service.domain.product;

import dmall.service.domain.Repository;

/**
 * @author walter
 */
public interface ProductRepository extends Repository {

    Product getById(Integer id);

    Product getBySN(String sn);

    void save(Product product);

}
