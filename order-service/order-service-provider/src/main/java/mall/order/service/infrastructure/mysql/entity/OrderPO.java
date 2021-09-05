package mall.order.service.infrastructure.mysql.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Data
public class OrderPO {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;
}
