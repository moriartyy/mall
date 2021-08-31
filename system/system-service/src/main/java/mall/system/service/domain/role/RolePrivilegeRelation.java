package mall.system.service.domain.role;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Walter
 */
@Getter
@Setter
public class RolePrivilegeRelation {

    private Integer id;
    private Integer roleId;
    private Integer privilegeId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
