package mall.service.domain;

/**
 * @author walter
 */
public interface Persistable<ID> {

    ID getId();

    void setId(ID id);
}
