package mall.infrastructure.repository.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import mall.service.domain.AuditableEntity;
import org.apache.ibatis.reflection.MetaObject;

/**
 * This need put @TableField(fill = FieldFill.INSERT_UPDATE) on entity field.
 * See {@link AuditingInnerInterceptor}
 *
 * @author walter
 */ //
public class AutoFillingMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.getOriginalObject() instanceof AuditableEntity) {
            AuditableEntity<?> auditable = (AuditableEntity<?>) metaObject.getOriginalObject();
            auditable.beforeInsert();
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.getOriginalObject() instanceof AuditableEntity) {
            AuditableEntity<?> auditable = (AuditableEntity<?>) metaObject.getOriginalObject();
            auditable.beforeUpdate();
        }
    }
}
