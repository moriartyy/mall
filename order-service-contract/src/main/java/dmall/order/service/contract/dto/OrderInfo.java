package dmall.order.service.contract.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Data
public class OrderInfo {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;
}
