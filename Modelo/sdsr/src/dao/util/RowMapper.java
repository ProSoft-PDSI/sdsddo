package dao.util;

import java.sql.ResultSet;

public interface RowMapper<T> {
	public abstract T mapRow(ResultSet rs);
}