package mall.system.service.domain;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Getter
public class Order {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;
}
