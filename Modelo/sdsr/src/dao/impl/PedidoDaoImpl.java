package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import dao.spec.PedidoDao;
import dao.util.AccesoDB;

public class PedidoDaoImpl implements PedidoDao {

	@Override
	public void InsertarPedido(String dni) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_insertapedidos(?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
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
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_eliminapedidos(?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, nropedido);
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
	public void ModificarPedido(String nropedido,String codproducto,int cant) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_agregardetallepedidos(?,?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, nropedido);
			cstm.setString(1, codproducto);
			cstm.setInt(3, cant);
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
	public void InsertarProductoPedidos(String nropedido,String codproducto,int cant) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_agregardetallepedidos(?,?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, nropedido);
			cstm.setString(1, codproducto);
			cstm.setInt(3, cant);
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

}
