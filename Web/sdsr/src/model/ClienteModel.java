package model;

import java.util.Date;

import dao.impl.ClienteDaoImpl;
import dao.spec.ClienteDao;
import entity.Cliente;

public class ClienteModel {
	public Cliente getCliente(String usuario){
		ClienteDao dao = new ClienteDaoImpl();
		return dao.getCliente(usuario);
	}
	
	public void insertaUsuario(String dni, String nomcliente,
			String direccioncliente, String emailcliente, Date fechanac,
			String telefono, String usuario,String contrasenia){
		ClienteDao dao = new ClienteDaoImpl();
		dao.insertaUsuario(dni, nomcliente, direccioncliente, 
				emailcliente, fechanac, telefono, usuario, contrasenia);
	}
}
