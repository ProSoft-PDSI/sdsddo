package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.UtilDate;
import dao.spec.ClienteDao;
import dao.util.AccesoDB;
import dao.util.RowMapper;
import entity.Cliente;

public class ClienteDaoImpl implements ClienteDao,RowMapper<Cliente> {

	@Override
	public Cliente getCliente(String usuario) {
		Connection cn=null;
		Cliente cli=null;
		try {
		    cn=AccesoDB.getConnection();
		    String sql="select * from cliente where usuario=?";
		    PreparedStatement pstm = cn.prepareStatement(sql);
		    pstm.setString(1,usuario);
		    ResultSet rs=pstm.executeQuery();
		    cli=mapRow(rs);
		    rs.next();
		    rs.close();
		    pstm.close();
		    return cli;
		} catch (Exception e) {
		    throw new RuntimeException(e.getMessage());
		}finally{
		    try {
			cn.close();
		    } catch (Exception e2) {
		    }
	}

}

	@Override
	public Cliente mapRow(ResultSet rs) {
		Cliente bean = new Cliente();
		try {
			bean.setNomcliente(rs.getString("nomcliente"));
			bean.setDni(rs.getString("dni"));
			bean.setDireccioncliente(rs.getString("direccioncliente"));
			bean.setEmailcliente(rs.getString("email"));
			bean.setFechanac(UtilDate.sqlToJava(rs.getDate("fechanac")));
			bean.setTelefono(rs.getString("telefono"));
			bean.setUsuario(rs.getString("usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
