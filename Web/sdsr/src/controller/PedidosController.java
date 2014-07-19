package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.PedidoDto;
import util.UtilDate;
import entity.Cliente;
import entity.DetallePedido;
import entity.Pedido;
import entity.Usuario;
import model.ControlModel;
import model.PedidosModel;
import model.ProductoModel;

@WebServlet({"/InsertarPedido","/EliminarPedido","/ModificarPedido","/ListaPedidos","/Entrada"})
public class PedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PedidosController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/InsertarPedido")){
				InsertarPedido(request,response);
		}else if(alias.equals("/EliminarPedido")){
				EliminarPedido(request,response);
		}else if(alias.equals("/ModificarPedido")){
				ModificarPedido(request,response);
		}else if(alias.equals("/Entrada")){
			EntradaPost(request,response);
		}
    }


	private void EntradaPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductoModel model = new ProductoModel();
		request.setAttribute("listamenu", model.getEntrada());
		HttpSession session = request.getSession(true);
		String Codigo = (String) session.getAttribute("codigo");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Pedido");
		rd.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/ListaPedidos")){
				ListaPedidos(request,response);
		}else if(alias.equals("/Entrada")){
			Entrada(request,response);
		}
	}

	private void Entrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoModel model = new ProductoModel();
		request.setAttribute("listamenu", model.getEntrada());
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Entrada.jsp");
		rd.forward(request, response);
		
	}
//revisar
	private void ListaPedidos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			//HttpSession session = request.getSession(true);
			String codProducto = (String) request.getAttribute("codigo");
			int cantidad = (Integer)request.getAttribute("cant");
			DetallePedido bean = new DetallePedido();
			ControlModel model = new ControlModel();
			bean.setNropedido(model.getValor("pedido"));
			bean.setCodproducto(codProducto);
			bean.setCant(cantidad);
			PedidoDto.addDetallePedido(bean);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("Pedido.jsp");
		rd.forward(request, response);

	}

	private void ModificarPedido(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void EliminarPedido(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	//revisar
	private void InsertarPedido(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			Cliente cli = (Cliente)session.getAttribute("cliente");
			PedidosModel model = new PedidosModel();
			Usuario usu = (Usuario)session.getAttribute("usuario");
			model.InsertarPedidos(cli.getDni(),usu.getUsuario());
			List<DetallePedido> lista = PedidoDto.getLista();
			model.InsertaProductosDetallePedido(lista, usu.getUsuario());
			Pedido pedido = model.getPedido(cli.getDni(), UtilDate.now());
			session.setAttribute("pedidos", pedido);
			session.setAttribute("totalpedido", pedido.getTotalpedido());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("pedidoInsertar.jsp");
		rd.forward(request, response);
	}

}
