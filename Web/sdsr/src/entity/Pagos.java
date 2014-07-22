package entity;

public class Pagos {
	private String nropedido;
	private String codtipo_pago;
	private double totalpedido;
	private double efectivo;
	private double cambio;
	private String estado;
	private String usuario;
	
	
	public Pagos() {
	}
	
	
	public String getNropedido() {
		return nropedido;
	}
	public void setNropedido(String nropedido) {
		this.nropedido = nropedido;
	}
	public String getCodtipo_pago() {
		return codtipo_pago;
	}
	public void setCodtipo_pago(String codtipo_pago) {
		this.codtipo_pago = codtipo_pago;
	}
	public double getTotalpedido() {
		return totalpedido;
	}
	public void setTotalpedido(double totalpedido) {
		this.totalpedido = totalpedido;
	}
	public double getEfectivo() {
		return efectivo;
	}
	public void setEfectivo(double efectivo) {
		this.efectivo = efectivo;
	}
	public double getCambio() {
		return cambio;
	}
	public void setCambio(double cambio) {
		this.cambio = cambio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
}
