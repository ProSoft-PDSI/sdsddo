package dao.spec;

import java.util.List;

import entity.Producto;

public interface ProductoDao {
	List<Producto> getEntrada();
	List<Producto> getEntradaClasico();
	List<Producto> getPizza();
	List<Producto> getPizzaClasico();
	List<Producto> getEspeciales();
	Producto getProducto(String Producto);
	String getNombreProducto(String codproducto);
}
