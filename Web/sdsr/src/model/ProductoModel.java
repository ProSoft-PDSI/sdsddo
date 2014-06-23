package model;

import java.util.List;

import dao.impl.ProductoDaoImpl;
import entity.Producto;

public class ProductoModel {
	public List<Producto> getMenu(){
		ProductoDaoImpl model = new ProductoDaoImpl();
		List<Producto> menu = model.getMenu();
		return menu;
	}
}
