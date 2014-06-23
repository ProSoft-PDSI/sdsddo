package entity;

public class DetallePedido {
	String nropedido;
	String codproducto;
	double preciounitario;
	int cant;
	double preciototal;
	
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
	public double getPreciounitario() {
		return preciounitario;
	}
	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public double getPreciototal() {
		return preciototal;
	}
	public void setPreciototal(double preciototal) {
		this.preciototal = preciototal;
	}
	
	
}
