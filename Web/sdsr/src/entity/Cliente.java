package entity;

public class Cliente {
	private String dni;                                       
	private String nomcliente;                                
	private String direccioncliente;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNomcliente() {
		return nomcliente;
	}
	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}
	public String getDireccioncliente() {
		return direccioncliente;
	}
	public void setDireccioncliente(String direccioncliente) {
		this.direccioncliente = direccioncliente;
	}                        
}
