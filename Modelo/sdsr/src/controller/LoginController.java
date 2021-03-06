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
@WebServlet({"/LoginIngreso","/Recuperacion"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/LoginIngreso")){
			login(request,response);
		}else if(alias.equals("/Recuperacion")){
			recuperacion(request,response);
		}
	}


	private void recuperacion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			LoginModel model = new LoginModel();
			Usuario usu = model.validaremail(email);
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usu);
			request.setAttribute("mensaje", "Correo Enviado");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Recuperacion.jsp");
		rd.forward(request, response);
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino = "home.jsp";
		try {
			String user1 = request.getParameter("usuario");
			String pass1 = request.getParameter("contrasenia");
			LoginModel model = new LoginModel();
			ClienteModel model1 =  new ClienteModel(); 
			Usuario usu1 = model.validarusuariocontraseņa(user1, pass1);
			Cliente cli1 = model1.getCliente(user1);
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
