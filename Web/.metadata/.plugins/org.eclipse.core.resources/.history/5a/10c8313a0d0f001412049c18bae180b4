package dao.spec;

import java.util.Date;
import java.util.Map;

import entity.Pedido;

public interface PedidoDao {
	public void InsertarPedido(String dni,String usuario);
	public void EliminarPedido(String nropedido,String usuario);
	public void ModificarPedido(String nropedido,String codproducto,int cant,String usuario);
	public void InsertarProductoPedidos(String nropedido,String codproducto,int cant,String usuario);
	public Map<String, String> listaPedidos(String nropedido);
	public Pedido getPedido(String dni,Date fecha);
}
