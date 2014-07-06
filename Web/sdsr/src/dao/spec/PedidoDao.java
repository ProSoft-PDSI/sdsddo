package dao.spec;

public interface PedidoDao {
	public void InsertarPedido(String dni);
	public void EliminarPedido(String nropedido);
	public void ModificarPedido(String nropedido,String codproducto,int cant);
	public void InsertarProductoPedidos(String nropedido,String codproducto,int cant);
}
