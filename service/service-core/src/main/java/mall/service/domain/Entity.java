package mall.service.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author walter
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Entity<ID extends Serializable> implements Persistable<ID> {

    @Id
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Transient
    public boolean isNew() {
        return this.id == null;
    }
}
