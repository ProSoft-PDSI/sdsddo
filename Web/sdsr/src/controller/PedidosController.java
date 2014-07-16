package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cliente;
import entity.Pedido;
import entity.Producto;
import model.PedidosModel;
import model.ProductoModel;

@WebServlet({"/InsertarPedido","/EliminarPedido","/ModificarPedido","/ListaPedidos","/Menu"})
public class PedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PedidosController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/InsertarPedido")){
			try {
				InsertarPedido(request,response);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("InsertarPedido.jsp");
				rd.forward(request, response);
			}
		}else if(alias.equals("/EliminarPedido")){
			try {
				EliminarPedido(request,response);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("EliminarPedido.jsp");
				rd.forward(request, response);
			}
		}else if(alias.equals("/ModificarPedido")){
			try {
				ModificarPedido(request,response);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("ModficarPedido.jsp");
				rd.forward(request, response);
			}
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/ListaPedidos")){
				ListaPedidos(request,response);
		}else{
			if(alias.equals("/Menu")){
				Menu(request,response);
			}
		}
	}

	private void Menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoModel model = new ProductoModel();
		List<Producto> menu = model.getMenu();
		for(Producto p:menu){
			System.out.println(p.getNombre());
		}
		request.setAttribute("listamenu", menu);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}

	private void ListaPedidos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			PedidosModel model = new PedidosModel();
			Map<String,String> lista = model.getListaPedidos(session.getAttribute("user"));
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
			model.InsertarPedidos(cli.getDni());
			Pedido pedido = 
			session.setAttribute("pedido", pedido);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("pedidoInsertar.jsp");
		rd.forward(request, response);
	}

}
