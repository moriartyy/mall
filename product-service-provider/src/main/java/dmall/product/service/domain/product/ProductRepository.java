package dmall.product.service.domain.product;

import dmall.ddd.domain.Repository;

/**
 * @author walter
 */
public interface ProductRepository extends Repository {

    Product getById(Integer id);

    Product getBySN(String sn);

    void save(Product product);

}
