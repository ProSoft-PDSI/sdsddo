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
import entity.Usuario;
import model.ClienteModel;
import model.LoginModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginIngreso")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "home.jsp";
		try {
			// Datos
			String user1 = request.getParameter("usuario");
			String pass1 = request.getParameter("contrasenia");
			// Proceso
			LoginModel model = new LoginModel();
			ClienteModel model1 =  new ClienteModel(); 
			Usuario usu1 = model.validar(user1, pass1);
			Cliente cli1 = model1.getCliente(user1);
			// Guardar dato en sesi�n
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usu1);
			session.setAttribute("cliente", cli1);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			paginaDestino = "login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
		rd.forward(request, response);
	}

}
