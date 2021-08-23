package mall.data.dictionary.service.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Data
@Builder
public class OrderQuery {
    private Integer id;
    private Integer amount;
    private String buyer;
    private LocalDateTime whenPlacedBegin;
    private LocalDateTime whenPlacedEnd;
}
