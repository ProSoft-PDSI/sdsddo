package model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.impl.PedidoDaoImpl;
import dao.spec.PedidoDao;
import entity.DetallePedido;
import entity.Pedido;

public class PedidosModel {
	public void InsertarPedidos(String dni,String usuario){
		PedidoDao dao = new PedidoDaoImpl();
		dao.InsertarPedido(dni,usuario);
	}
	
	public void InsertaProductosDetallePedido(List<DetallePedido> pedido,String usuario){
		PedidoDao dao = new PedidoDaoImpl();
		for(DetallePedido i : pedido){
			dao.InsertarProductoPedidos(i.getNropedido(), i.getCodproducto(), i.getCant(),usuario);
		}
	}
	
	public Map<String,String> getListaPedidos(String nropedido){
		PedidoDao dao = new PedidoDaoImpl();
		return dao.listaPedidos(nropedido);
	}
	
	public Pedido getPedido(String dni,Date fecha){
		PedidoDao dao = new PedidoDaoImpl();
		return dao.getPedido(dni, fecha);
		
	}
	
}
