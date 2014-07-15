package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.spec.ControlDao;
import dao.util.AccesoDB;

public class ControlDaoImpl implements ControlDao {

	@Override
	public String getValor(String parametro) {
		Connection cn=null;
		String valor;
		try {
		    cn=AccesoDB.getConnection();
		    String sql="select valor from control where parametro=?";
		    PreparedStatement pstm = cn.prepareStatement(sql);
		    pstm.setString(1,parametro);
		    ResultSet rs=pstm.executeQuery();
		    rs.next();
		    valor=rs.getString(1);
		    rs.close();
		    pstm.close();
		    
		} catch (Exception e) {
		    throw new RuntimeException(e.getMessage());
		}finally{
		    try {
			cn.close();
		    } catch (Exception e2) {
		    }
		}
		return valor;
	}

}
