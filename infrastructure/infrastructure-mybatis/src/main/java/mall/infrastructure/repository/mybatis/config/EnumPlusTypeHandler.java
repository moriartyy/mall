package mall.infrastructure.repository.mybatis.config;

import mall.service.enums.EnumPlus;
import mall.service.util.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author walter
 */
public class EnumPlusTypeHandler<T extends EnumPlus> extends BaseTypeHandler<T> {

    private final Class<T> enumType;

    public EnumPlusTypeHandler(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return rs.wasNull() ? null : EnumUtils.getByValue(this.enumType, value);

    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return rs.wasNull() ? null : EnumUtils.getByValue(this.enumType, value);

    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return cs.wasNull() ? null : EnumUtils.getByValue(this.enumType, value);
    }
}
