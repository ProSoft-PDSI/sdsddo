package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.UtilDate;
import dao.spec.PedidoDao;
import dao.util.AccesoDB;
import dao.util.RowMapper;
import entity.Pedido;

public class PedidoDaoImpl implements PedidoDao,RowMapper<Pedido> {

	@Override
	public void InsertarPedido(String dni,String usuario) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_insertapedidos(?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, usuario);
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
	public void EliminarPedido(String nropedido,String usuario) {
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
	public void ModificarPedido(String nropedido,String codproducto,int cant,String usuario) {
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
	public void InsertarProductoPedidos(String nropedido,String codproducto,int cant,String usuario) {
		Connection cn=null;
		try {
			cn=AccesoDB.getConnection();
			cn.setAutoCommit(false);
			String sql="{call sp_insertadetallepedido(?,?,?,?)}";
			CallableStatement cstm = cn.prepareCall(sql);
			cstm.setString(1, nropedido);
			cstm.setString(2, codproducto);
			cstm.setInt(3, cant);
			cstm.setString(4,usuario);
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
	public Pedido getPedido(String nropedido) {
		Connection cn=null;
		Pedido ped=null;
		try {
			cn=AccesoDB.getConnection();
			String sql = "select nropedido,dni,fecha,subtotalpedido,igv,"
					+ "totalpedido,estado "
					+ "from pedido "
					+ "where nropedido=?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, nropedido);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				mapRow(rs);
			}
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (Exception e2) {
				
			}
		}
		return ped;
	}

	@Override
	public Pedido mapRow(ResultSet rs) {
		Pedido bean = new Pedido();
		try {
			bean.setNropedido(rs.getString("nropedido"));
			bean.setDni(rs.getString("dni"));
			bean.setFecha(UtilDate.sqlToJava(rs.getDate("fecha")));
			bean.setSubtotalpedido(rs.getDouble("totalpedido"));
			bean.setIgv(rs.getDouble("igv"));
			bean.setTotalpedido(rs.getDouble("totalpedido"));
			bean.setEstado(rs.getString("estado"));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}


}
