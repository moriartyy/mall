package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.core.domain.Entity;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Setter
@Getter
public class Order implements Entity<Integer> {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;

}
