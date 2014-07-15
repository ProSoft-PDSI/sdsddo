package entity;

import java.util.Date;

public class Pedido {
	String nropedido;
	String dni;
	Date fecha;
	double subtotalpedido;
	double igv;
	double totalpedido;
	
	public String getNropedido() {
		return nropedido;
	}
	public void setNropedido(String nropedido) {
		this.nropedido = nropedido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getSubtotalpedido() {
		return subtotalpedido;
	}
	public void setSubtotalpedido(double subtotalpedido) {
		this.subtotalpedido = subtotalpedido;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}
	public double getTotalpedido() {
		return totalpedido;
	}
	public void setTotalpedido(double totalpedido) {
		this.totalpedido = totalpedido;
	}
	
}
