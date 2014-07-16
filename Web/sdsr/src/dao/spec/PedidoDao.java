package dao.spec;

import java.util.Date;
import java.util.Map;

import entity.Pedido;

public interface PedidoDao {
	public void InsertarPedido(String dni);
	public void EliminarPedido(String nropedido);
	public void ModificarPedido(String nropedido,String codproducto,int cant);
	public void InsertarProductoPedidos(String nropedido,String codproducto,int cant);
	public Map<String, String> listaPedidos();
	public Pedido getPedido(String dni,Date fecha);
}
