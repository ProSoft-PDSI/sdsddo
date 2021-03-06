package dao.spec;

import entity.Pedido;

public interface PedidoDao {
	public void InsertarPedido(String dni,String usuario);
	public void EliminarPedido(String nropedido,String usuario);
	public void ModificarPedido(String nropedido,String codproducto,int cant,String usuario);
	public void InsertarProductoPedidos(String nropedido,String codproducto,int cant,String usuario);
	public Pedido getPedido(String nropedido);
}
