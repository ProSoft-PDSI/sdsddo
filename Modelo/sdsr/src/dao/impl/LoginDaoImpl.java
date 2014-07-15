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
    public Usuario validarlogin(String user) {
	Connection cn = null;
	Usuario usu = null;
	try {
	    cn=AccesoDB.getConnection();
	    String sql="select usuario,contrasenia,tipo from usuario where usuario = ?";
	    PreparedStatement pstm=cn.prepareStatement(sql);
	    pstm.setString(1 ,user);
	    ResultSet rs=pstm.executeQuery();
	    while(rs.next()){
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
		Usuario bean = null;
		try {
			bean=new Usuario();
			bean.setUsuario(rs.getString("usuario"));
			bean.setContrasenia(rs.getString("contrasenia"));
			bean.setTipo(rs.getString("tipo"));
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return bean;
	}

	@Override
	public Usuario validarEmail(String email) {
		Connection cn = null;
		Usuario usu = null;
		try {
		    cn=AccesoDB.getConnection();
		    String sql="select usuario from cliente where email = ?"
		    		+ "group by usuario";
		    PreparedStatement pstm=cn.prepareStatement(sql);
		    pstm.setString(1 ,email);
		    ResultSet rs=pstm.executeQuery();
		    while(rs.next()){
		    	 int numencontrados = rs.getInt("cuenta");
		    	 System.out.println(numencontrados);
				 String user = rs.getString("usuario");
				 usu=validarlogin(user);
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
