package dao.spec;

import java.util.List;

import entity.Producto;

public interface ProductoDao {
	List<Producto> getMenu();
	Producto getProducto(String Producto);
}
