package entity;

import java.util.Date;

public class Cliente {
	private String dni;                                       
	private String nomcliente;                                
	private String direccioncliente;
	private String emailcliente;
	private Date fechanac;
	private String telefono;
	private String usuario;
	
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
	public String getEmailcliente() {
		return emailcliente;
	}
	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}
	public Date getFechanac() {
		return fechanac;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}                        
}
