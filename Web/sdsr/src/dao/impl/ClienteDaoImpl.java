package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
		    while(rs.next()){
		    	cli=mapRow(rs);
		    }
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

	@Override
	public void insertaUsuario(String dni, String nomcliente,
			String direccioncliente, String emailcliente, Date fechanac,
			String telefono, String usuario,String contrasenia) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_insertacliente(?,?,?,?,?,?,?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, nomcliente);
			cstm.setString(3, direccioncliente);
			cstm.setString(4, emailcliente);
			cstm.setDate(5, UtilDate.javaToSQL(fechanac));
			cstm.setString(6, telefono);
			cstm.setString(7, usuario);
			cstm.setString(8, contrasenia);
			cstm.executeUpdate();
			cstm.close();			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (Exception e2) {
				
			}
		}
		
	}
}
