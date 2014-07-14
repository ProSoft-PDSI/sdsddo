package model;

import dao.impl.LoginDaoImpl;
import dao.impl.MensajeDaoImpl;
import dao.spec.LoginDao;
import dao.spec.MensajeDao;
import entity.Usuario;

public class LoginModel {
	public Usuario validarusuariocontraseņa(String user, String pass) {
		Usuario usu;
		LoginDao dao = new LoginDaoImpl();
		usu = dao.validarlogin(user);
		MensajeDao men = new MensajeDaoImpl();
		if(user == "" || pass == ""){
			throw new RuntimeException(men.getMensaje("MEN003"));
		}
		if(usu == null){
			throw new RuntimeException(men.getMensaje("MEN001"));
		}
		if(!usu.getContrasenia().equals(pass)){
			throw new RuntimeException(men.getMensaje("MEN002"));
		}
		return usu;
	}
	
	
	public Usuario validaremail(String email) {
		Usuario usu;
		LoginDao dao = new LoginDaoImpl();
		usu=dao.validarEmail(email);
		return usu;
	}
	
	
}