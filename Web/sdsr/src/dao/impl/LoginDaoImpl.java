package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.spec.LoginDao;
import dao.util.AccesoDB;
import entity.Usuario;

public class LoginDaoImpl implements LoginDao {


    @Override
    public Usuario validarlogin(String user) {
	Connection cn = null;
	Usuario usu = null;
	try {
	    cn=AccesoDB.getConnection();
	    String sql="select usuario,contrasenia,tipo from usuario where usuario=?";
	    PreparedStatement pstm=cn.prepareStatement(sql);
	    pstm.setString(1 ,user);
	    ResultSet rs=pstm.executeQuery();
	    while(rs.next()){
	    	usu = new Usuario();
	    	usu.setUsuario(rs.getString("usuario"));
	    	usu.setContrasenia(rs.getString("contrasenia"));
	    	usu.setTipo(rs.getString("tipo"));
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

}