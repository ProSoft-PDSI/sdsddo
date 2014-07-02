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
		usu = dao.validarlogin(user);
		MensajeDao men = new MensajeDaoImpl();
		if(usu == null || !usu.getContrasenia().equals(pass)){
			throw new RuntimeException(men.getMensaje("000001") +" o "+men.getMensaje("000002"));
		}
		return usu;
	}
	
	
}