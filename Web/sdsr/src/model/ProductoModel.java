package model;

import java.util.List;

import dao.impl.ProductoDaoImpl;
import dao.spec.ProductoDao;
import entity.Producto;

public class ProductoModel {
	public List<Producto> getEntrada(){
		ProductoDao dao = new ProductoDaoImpl();
		List<Producto> entrada = dao.getEntrada();
		return entrada;
	}
	
	public List<Producto> getEntradaClasico(){
		ProductoDao dao = new ProductoDaoImpl();
		List<Producto> entrada = dao.getEntradaClasico();
		return entrada;
	}
	
	public List<Producto> getPizza(){
		ProductoDao dao = new ProductoDaoImpl();
		List<Producto> entrada = dao.getPizza();
		return entrada;
	}
	
	public List<Producto> getEspeciales(){
		ProductoDao dao = new ProductoDaoImpl();
		List<Producto> entrada = dao.getEspeciales();
		return entrada;
	}
	
	public List<Producto> getPizzaClasico(){
		ProductoDao dao = new ProductoDaoImpl();
		List<Producto> entrada = dao.getPizzaClasico();
		return entrada;
	}
	
	public Producto getProducto(String codProducto){
		ProductoDao dao = new ProductoDaoImpl();
		return dao.getProducto(codProducto);
		
	}
}
