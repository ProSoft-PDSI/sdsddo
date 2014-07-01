package model;

import java.util.List;

import dao.impl.ProductoDao;
import entity.Producto;

public class ProductoModel {
	public List<Producto> getMenu(){
		ProductoDao model = new ProductoDao();
		List<Producto> menu = model.getMenu();
		return menu;
	}
}
