package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import dao.spec.PagoDao;
import dao.util.AccesoDB;

public class PagoDaoImpl implements PagoDao {

	@Override
	public void InsertarPago(String nropedido, String codtipo_pago,
			double totalpedido, double efectivo, double cambio, String estado,
			String usuario) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_agregarpago(?,?,?,?,?,?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, nropedido);
			cstm.setString(2, codtipo_pago);
			cstm.setDouble(3, totalpedido);
			cstm.setDouble(4, efectivo);
			cstm.setDouble(5, cambio);
			cstm.setString(6, estado);
			cstm.setString(7, usuario);
			cstm.execute();
			cstm.close();
			cn.commit();
		} catch (Exception e) {
			try {
				cn.rollback(); // Cancela la Tx
			} catch (Exception e2) {
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}

	}

}
