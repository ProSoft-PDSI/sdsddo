package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cliente;
import model.PedidosModel;

@WebServlet({"/InsertarPedido","/EliminarPedido","/ModificarPedido"})
public class PedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PedidosController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("pedidoInsertar.jsp");
		rd.forward(request, response);
	}

}
