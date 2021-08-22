package mall.order.service.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mall.core.domain.Entity;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Setter(AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor
public class Order implements Entity<Integer> {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;

    public Order(Integer id) {
        this.id = id;
    }
}
