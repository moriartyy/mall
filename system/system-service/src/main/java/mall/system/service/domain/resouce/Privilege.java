package mall.system.service.domain.resouce;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Walter
 */
@Getter
@Setter
public class Privilege {

    private Integer id;
    private String name;
    private String code;
    private Integer operationId;
    private Integer resourceId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
