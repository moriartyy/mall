package mall.infrastructure.repository.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import mall.service.domain.AuditableEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author walter
 */
public class AuditingInnerInterceptor implements InnerInterceptor {

    public void beforeUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
        if (parameter instanceof AuditableEntity) {
            prepareEntity(ms, (AuditableEntity<?>) parameter);
        } else if (parameter instanceof Map) {
            Map<?, ?> parameterMap = (Map<?, ?>) parameter;
            parameterMap.values().forEach(p -> {
                if (p instanceof AuditableEntity) {
                    prepareEntity(ms, (AuditableEntity<?>) p);
                }
            });
        }
    }

    private void prepareEntity(MappedStatement ms, AuditableEntity<?> auditableEntity) {
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
