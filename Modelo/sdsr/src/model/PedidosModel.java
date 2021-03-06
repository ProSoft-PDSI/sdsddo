package model;

import java.util.List;

import dao.impl.PedidoDaoImpl;
import dao.spec.PedidoDao;
import entity.DetallePedido;

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
	
	
}
