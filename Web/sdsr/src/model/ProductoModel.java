package model;

import java.util.List;

import dao.impl.ProductoDaoImpl;
import entity.Producto;

public class ProductoModel {
	public List<Producto> getEntrada(){
		ProductoDaoImpl dao = new ProductoDaoImpl();
		List<Producto> menu = dao.getEntrada();
		return menu;
	}
	
	public Producto getProducto(){
		
		return null;
		
	}
}
