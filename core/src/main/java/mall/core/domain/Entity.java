package mall.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author walter
 */
@Getter
@Setter
public abstract class Entity<ID extends Serializable> {
    private ID id;
}
