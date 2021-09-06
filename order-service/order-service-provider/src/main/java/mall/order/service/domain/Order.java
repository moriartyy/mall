package mall.order.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.service.domain.Entity;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Setter
@Getter
public class Order extends Entity<Integer> {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;

}
