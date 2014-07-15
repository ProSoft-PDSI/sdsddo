package dao.spec;

import java.util.Date;

import entity.Cliente;

public interface ClienteDao {
	public Cliente getCliente(String usuario);
	public void insertaUsuario(String dni,String nomcliente, String direccioncliente,
			String emailcliente,Date fechanac,String telefono,
			String usuario,String contrasenia);
}
