package model;

import dao.impl.Logindao;
import dao.spec.ILogin;

public class Loginmodel {
	public void permitirAcceso(String user,String pass){
		try{
			ILogin dao = new Logindao();
			if(dao.verificarDatos(user, pass)){
				//aqui falta decir adonde ira
			}else{
				throw new Exception("El nombre de usuario o la contraseņa es incorrecto");
			}
		}catch(Exception e){
			
		}
	}
}
