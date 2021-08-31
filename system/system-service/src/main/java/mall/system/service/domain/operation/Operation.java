package mall.system.service.domain.operation;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Walter
 */
@Getter
@Setter
public class Operation {

    private Integer id;
    private String name;
    private String code;
    private String description;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
