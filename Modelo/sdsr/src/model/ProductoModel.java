package model;

import java.util.List;

import dao.impl.ProductoDaoImpl;
import entity.Producto;

public class ProductoModel {
	public List<Producto> getMenu(){
		ProductoDaoImpl dao = new ProductoDaoImpl();
		List<Producto> menu = dao.getMenu();
		return menu;
	}
	
	public Producto getProducto(){
		
		return null;
		
	}
}
