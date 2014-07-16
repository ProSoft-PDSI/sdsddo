package model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.impl.PedidoDaoImpl;
import dao.spec.PedidoDao;
import entity.DetallePedido;
import entity.Pedido;

public class PedidosModel {
	public void InsertarPedidos(String dni){
		PedidoDao dao = new PedidoDaoImpl();
		dao.InsertarPedido(dni);
	}
	
	public void InsertaProductosDetallePedido(List<DetallePedido> pedido){
		PedidoDao dao = new PedidoDaoImpl();
		for(DetallePedido i : pedido){
			dao.InsertarProductoPedidos(i.getNropedido(), i.getCodproducto(), i.getCant());
		}
	}
	
	public Map<String,String> getListaPedidos(){
		PedidoDao dao = new PedidoDaoImpl();
		return dao.listaPedidos();
		
	}
	
	public Pedido getPedido(String dni,Date fecha){
		
		
		return null;
		
	}
	
}
