package mall.system.service.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Data
public class UserInfo {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlaced;
}
