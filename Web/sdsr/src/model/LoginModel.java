package model;

import dao.impl.LoginDao;
import dao.impl.MensajeDao;
import dao.spec.ILoginDao;
import dao.spec.IMensajeDao;
import entity.Usuario;

public class LoginModel {
	public Usuario validar(String user, String pass) {
		Usuario usu;
		ILoginDao dao = new LoginDao();
		usu = dao.validarlogin(user);
		IMensajeDao men = new MensajeDao();
		if(usu == null || !usu.getContrasenia().equals(pass)){
			throw new RuntimeException(men.getMensaje("000001") +" o "+men.getMensaje("000002"));
		}
		return usu;
	}
	
	
}