package dto;

import java.util.List;

import entity.DetallePedido;

public class PedidoDto {
	private static List<DetallePedido> lista;

	public static List<DetallePedido> getLista() {
		return lista;
	}

	public static void addDetallePedido(DetallePedido bean){
		lista.add(bean);
	}
	
	
}
