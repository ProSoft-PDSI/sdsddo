package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.spec.LoginDao;
import dao.util.AccesoDB;
import dao.util.RowMapper;
import entity.Usuario;

public class LoginDaoImpl implements LoginDao,RowMapper<Usuario> {


    @Override
    public Usuario validarlogin(String user,String pass) {
	Connection cn = null;
	Usuario usu = null;
	try {
	    cn=AccesoDB.getConnection();
	    String sql="select usuario,contrasenia,tipo from usuario where usuario = ? "
	    		+ "and contrasenia = ?";
	    PreparedStatement pstm=cn.prepareStatement(sql);
	    pstm.setString(1 ,user);
	    pstm.setString(2, pass);
	    ResultSet rs=pstm.executeQuery();
	    rs.next();
	    
	    if(rs.wasNull()){
	    	throw new Exception("Usuario o Contraseņa Incorrecta!!!");
	    }else{
	    	usu = mapRow(rs);	
	    }
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
	return usu;
	
    }

	@Override
	public Usuario mapRow(ResultSet rs) {
		Usuario bean = new Usuario();
		try {
			bean.setUsuario(rs.getString("usuario"));
			bean.setContrasenia(rs.getString("contrasenia"));
			bean.setTipo(rs.getString("tipo"));
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

}
