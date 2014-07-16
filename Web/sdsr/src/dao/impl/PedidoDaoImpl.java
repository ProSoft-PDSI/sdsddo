package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import dao.spec.PedidoDao;
import dao.spec.ProductoDao;
import dao.util.AccesoDB;
import entity.Pedido;

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
			String sql="{call sp_modificarpedido(?,?,?)}";
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
			String sql="{call sp_insertadetallepedido(?,?,?)}";
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
	public Map<String,String> listaPedidos() {
		Connection cn=null;
		Map<String,String> listapedidos = new Hashtable<String, String>();
		try {
			cn=AccesoDB.getConnection();
			String sql = "select codproducto,cant from detallepedido";
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ProductoDao dao = new ProductoDaoImpl(); 
			
			while(rs.next()){
				String nombre = dao.getNombreProducto(rs.getString("codproducto"));
				int cant = rs.getInt("cant");
				listapedidos.put(nombre, String.valueOf(cant));
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (Exception e2) {
				
			}
		}
		return listapedidos;
	}

	@Override
	public Pedido getPedido(String dni, Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
