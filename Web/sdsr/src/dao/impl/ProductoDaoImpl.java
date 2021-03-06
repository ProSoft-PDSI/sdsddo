package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.spec.ProductoDao;
import dao.util.AccesoDB;
import dao.util.RowMapper;
import entity.Producto;

public class ProductoDaoImpl implements ProductoDao,RowMapper<Producto> {

	@Override
	public List<Producto> getEntrada() {
		List<Producto> menu=new ArrayList<Producto>();
		Connection cn=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select * from producto where categoria = 'normal' and codproducto like 'EN%' ";
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				menu.add(mapRow(rs));
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return menu;
	}
	
	
	public List<Producto> getEntradaClasico() {
		List<Producto> menu=new ArrayList<Producto>();
		Connection cn=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select * from producto where categoria = 'clasico' and codproducto like 'EN%' ";
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				menu.add(mapRow(rs));
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return menu;
	}
	
	
	public Producto mapRow(ResultSet rs) {
		Producto bean = new Producto();
		try {
			bean.setCodProducto(rs.getString("codproducto"));
			bean.setNombre(rs.getString("nombreproducto"));
			bean.setDescripcion(rs.getString("descrproducto"));
			bean.setPrecio(rs.getDouble("preciounitario"));
			bean.setCategoria(rs.getString("categoria"));
			bean.setImagen(rs.getString("imagen"));
			bean.setStock(rs.getInt("stock"));
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return bean;
		
	}

	@Override
	public Producto getProducto(String codproducto) {
		Connection cn=null;
		Producto pro = new Producto();
		try {
			cn = AccesoDB.getConnection();
			String sql="select * from producto where codproducto = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, codproducto);
			ResultSet rs = pstm.executeQuery(sql);
			rs.next();
			pro=mapRow(rs);
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return pro;
	}

	@Override
	public String getNombreProducto(String codproducto) {
		Connection cn=null;
		String nombre=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select nombreproducto from producto where codproducto = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, codproducto);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()){
				nombre= rs.getString("nombreproducto");
			}
		
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return nombre;
	}


	@Override
	public List<Producto> getPizza() {
		List<Producto> menu=new ArrayList<Producto>();
		Connection cn=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select replace(nombreproducto,'Personal',''),descrproducto,categoria,imagen,stock from producto where categoria = 'normal'"
					+ "and codproducto like 'PI%'"
					+ "and nombreproducto like '%Personal'";
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Producto bean = new Producto();
				bean.setCodProducto("PI");
				bean.setNombre(rs.getString(1));
				bean.setDescripcion(rs.getString("descrproducto"));
				bean.setPrecio(0);
				bean.setCategoria(rs.getString("categoria"));
				bean.setImagen(rs.getString("imagen"));
				bean.setStock(rs.getInt("stock"));
				menu.add(bean);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return menu;
	}


	@Override
	public List<Producto> getPizzaClasico() {
		List<Producto> menu=new ArrayList<Producto>();
		Connection cn=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select replace(nombreproducto,'Personal',''),descrproducto,categoria,imagen,stock from producto where categoria = 'clasico'"
					+ "and codproducto like 'PI%'"
					+ "and nombreproducto like '%Personal'";
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Producto bean = new Producto();
				bean.setCodProducto("PI");
				bean.setNombre(rs.getString(1));
				bean.setDescripcion(rs.getString("descrproducto"));
				bean.setPrecio(0);
				bean.setCategoria(rs.getString("categoria"));
				bean.setImagen(rs.getString("imagen"));
				bean.setStock(rs.getInt("stock"));
				menu.add(bean);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return menu;
	}


	@Override
	public List<Producto> getEspeciales() {
		List<Producto> menu=new ArrayList<Producto>();
		Connection cn=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select * from producto where codproducto like 'ES%'";
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				menu.add(mapRow(rs));
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return menu;
	}

}
