package model;

import dao.impl.ClienteDaoImpl;
import dao.spec.ClienteDao;
import entity.Cliente;

public class ClienteModel {
	public Cliente getCliente(String usuario){
		ClienteDao dao = new ClienteDaoImpl();
		return dao.getCliente(usuario);
	}
}
