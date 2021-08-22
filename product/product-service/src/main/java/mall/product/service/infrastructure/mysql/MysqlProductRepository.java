package mall.product.service.infrastructure.mysql;

import mall.infrastructure.mybatis.config.MybatisRepository;
import mall.product.service.domain.product.Product;
import mall.product.service.domain.product.ProductRepository;

/**
 * @author walter
 */
public interface MysqlProductRepository extends ProductRepository, MybatisRepository<Integer, Product> {


}
