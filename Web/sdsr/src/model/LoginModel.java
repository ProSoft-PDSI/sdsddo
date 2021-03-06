package model;

import util.UtilMail;
import dao.impl.LoginDaoImpl;
import dao.impl.MensajeDaoImpl;
import dao.spec.LoginDao;
import dao.spec.MensajeDao;
import entity.Usuario;

public class LoginModel {
	public Usuario validarusuariocontrase�a(String user, String pass) {
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
		MensajeDao men = new MensajeDaoImpl();
		if(usu == null){
			throw new RuntimeException(men.getMensaje("MEN004"));
		}
		return usu;
	}
	
	public void mandarEmail(String receptor){
		UtilMail mail = new UtilMail();
		mail.setReceptor(receptor);
		String Mensaje = "sadkal�sdkla�skd�lasdl�aksl�dka�sld";
		mail.sendEmail(Mensaje);
		
	}
}