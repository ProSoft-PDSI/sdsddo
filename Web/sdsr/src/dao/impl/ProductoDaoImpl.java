package dao.impl;

import java.sql.Connection;
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
	public List<Producto> getMenu() {
		List<Producto> menu=new ArrayList<Producto>();
		Connection cn=null;
		try {
			cn = AccesoDB.getConnection();
			String sql="select * from producto";
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
			bean.setNombre(rs.getString("descrproducto"));
			bean.setPrecio(rs.getDouble("preciounitario"));
			bean.setStock(rs.getInt("stock"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
		
	}

}
