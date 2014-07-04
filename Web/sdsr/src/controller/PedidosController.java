package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertarPedido")
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
				RequestDispatcher rd = request.getRequestDispatcher("alumno_insertar.jsp");
				rd.forward(request, response);
			}
		}
	}

	private void InsertarPedido(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
