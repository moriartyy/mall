package mall.product.service.domain.product;

/**
 * @author walter
 */
public class ProductFactory {
    private String sn;
    private String name;

    public static ProductFactory newInstance() {
        return new ProductFactory();
    }

    public ProductFactory withSN(String sn) {
        return doWith(() -> this.sn = sn);
    }

    public ProductFactory withName(String name) {
        return doWith(() -> this.name = name);
    }

    ProductFactory doWith(Runnable action) {
        action.run();
        return this;
    }

    public Product create() {
        Product p = new Product();
        p.setSn(sn);
        p.setName(name);
        return p;
    }
}
