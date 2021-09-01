package mall.infrastructure.repository.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import mall.core.domain.AuditableEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;

import java.sql.SQLException;

/**
 * @author walter
 */
public class AuditingInnerInterceptor implements InnerInterceptor {

    public void beforeUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
        if (parameter instanceof AuditableEntity) {
            AuditableEntity<?> auditableEntity = (AuditableEntity<?>) parameter;
            switch (ms.getSqlCommandType()) {
                case INSERT:
                    auditableEntity.beforeInsert();
                    break;
                case UPDATE:
                    auditableEntity.beforeUpdate();
                    break;
            }
        }
    }
}
