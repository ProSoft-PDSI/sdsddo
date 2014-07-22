package dao.spec;

public interface PagoDao {
	public void InsertarPago(String nropedido, String codtipo_pago, double totalpedido, double efectivo,
			double cambio, String estado, String usuario);
	
}
