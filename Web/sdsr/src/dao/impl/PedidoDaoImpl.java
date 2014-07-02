package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;

import util.UtilDate;
import dao.spec.PedidoDao;
import dao.util.AccesoDB;

public class PedidoDaoImpl implements PedidoDao {

	@Override
	public void InsertarPedido(String dni,Date fecha) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_insertapedidos(?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setDate(2, UtilDate.javaToSQL(fecha));
			cstm.executeUpdate();
			cstm.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (Exception e2) {
				
			}
		}


	}

	@Override
	public void EliminarPedido(String nropedido) {
	
	}

	@Override
	public void ModificarPedido(String nropedido) {

	}

	@Override
	public void InsertarProductoPedidos(String nropedidos) {
		// TODO Auto-generated method stub
		
	}

}