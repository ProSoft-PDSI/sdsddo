package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilDate;
import entity.Cliente;
import entity.Pedido;
import entity.Usuario;
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

	private void ListaPedidos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			PedidosModel model = new PedidosModel();
			Pedido ped = (Pedido)session.getAttribute("pedido");
			Map<String,String> lista = model.getListaPedidos(ped.getNropedido());
			session.setAttribute("listapedido", lista);
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

	private void InsertarPedido(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			Cliente cli = (Cliente)session.getAttribute("cliente");
			PedidosModel model = new PedidosModel();
			Usuario usu = (Usuario)session.getAttribute("usuario");
			model.InsertarPedidos(cli.getDni(),usu.getUsuario());
			Pedido pedido = model.getPedido(cli.getDni(), UtilDate.now());
			session.setAttribute("pedido", pedido);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("pedidoInsertar.jsp");
		rd.forward(request, response);
	}

}
