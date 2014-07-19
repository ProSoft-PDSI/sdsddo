package dao.spec;

import java.util.List;

import entity.Producto;

public interface ProductoDao {
	List<Producto> getEntrada();
	Producto getProducto(String Producto);
	String getNombreProducto(String codproducto);
}
