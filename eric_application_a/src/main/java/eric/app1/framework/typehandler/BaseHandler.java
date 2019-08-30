package eric.app1.framework.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年8月16日 下午5:14:52
 * @Description
 */

public abstract class BaseHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
	private Class<E> type;

	public BaseHandler() {

	}

	public BaseHandler(Class<E> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		if (jdbcType == null) {
			ps.setString(i, parameter.name());
		} else {
			ps.setObject(i, parameter.name(), jdbcType.TYPE_CODE);
		}
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String s = rs.getString(columnName);
		return s == null ? null : Enum.valueOf(type, s);
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String s = rs.getString(columnIndex);
		return s == null ? null : Enum.valueOf(type, s);
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String s = cs.getString(columnIndex);
		return s == null ? null : Enum.valueOf(type, s);
	}

}
