package entity;

import java.io.Serializable;

public class DetallePedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nropedido;
	String codproducto;
	int cant;
;
	
	public String getNropedido() {
		return nropedido;
	}
	public void setNropedido(String nropedido) {
		this.nropedido = nropedido;
	}
	public String getCodproducto() {
		return codproducto;
	}
	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}

	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}

	
	
}
