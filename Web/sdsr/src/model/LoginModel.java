package model;

import dao.impl.LoginDaoImpl;
import dao.impl.MensajeDaoImpl;
import dao.spec.LoginDao;
import dao.spec.MensajeDao;
import entity.Usuario;

public class LoginModel {
	public Usuario validar(String user, String pass) {
		Usuario usu;
		LoginDao dao = new LoginDaoImpl();
		usu = dao.validarlogin(user,pass);
		MensajeDao men = new MensajeDaoImpl();
		if(usu == null){
			throw new RuntimeException(men.getMensaje("MEN001"));
		}
		if(!usu.getContrasenia().equals(pass)){
			throw new RuntimeException(men.getMensaje("MEN002"));
		}
		System.out.println(usu.getUsuario());
		return usu;
	}
	
	
}