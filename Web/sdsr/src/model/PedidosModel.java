package model;

import java.util.Date;

import dao.impl.PedidoDaoImpl;
import dao.spec.PedidoDao;

public class PedidosModel {
	public void InsertarPedidos(String dni , Date fecha){
		PedidoDao dao = new PedidoDaoImpl();
		dao.InsertarPedido(dni, fecha);
	}
}
