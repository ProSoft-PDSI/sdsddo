package model;

import dao.impl.PagoDaoImpl;
import dao.spec.PagoDao;

public class PagosModel {
	public void InsertarPago(String nropedido, String codtipo_pago,
			double totalpedido, double efectivo, double cambio, String estado,
			String usuario){
		PagoDao dao = new PagoDaoImpl();
		dao.InsertarPago(nropedido, codtipo_pago, totalpedido, efectivo, cambio, estado, usuario);
	}
}
