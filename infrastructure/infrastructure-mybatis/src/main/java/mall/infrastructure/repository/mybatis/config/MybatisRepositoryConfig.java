package mall.infrastructure.repository.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import mall.common.enums.EnumPlus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walter
 */
@Configuration
public class MybatisRepositoryConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (config -> {
            config.getTypeHandlerRegistry().register(EnumPlus.class, EnumPlusTypeHandler.class);
        });
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(new AuditingInnerInterceptor());
        return interceptor;
    }

    @Bean
    public AutoFillingMetaObjectHandler defaultValueMetaObjectHandler() {
        return new AutoFillingMetaObjectHandler();
    }


}
