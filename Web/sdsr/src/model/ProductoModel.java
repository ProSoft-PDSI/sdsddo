package model;

import java.util.List;

import dao.impl.ProductoDaoImpl;
import dao.spec.ProductoDao;
import entity.Producto;

public class ProductoModel {
	public List<Producto> getEntrada(){
		ProductoDao dao = new ProductoDaoImpl();
		List<Producto> menu = dao.getEntrada();
		return menu;
	}
	
	public Producto getProducto(String codProducto){
		ProductoDao dao = new ProductoDaoImpl();
		return dao.getProducto(codProducto);
		
	}
}
