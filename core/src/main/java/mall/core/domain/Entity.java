package mall.core.domain;

import lombok.Getter;
import lombok.Setter;


/**
 * @author walter
 */
@Getter
@Setter
public abstract class Entity<ID> {

    private ID id;

    public boolean isNew() {
        return this.id == null;
    }
}
