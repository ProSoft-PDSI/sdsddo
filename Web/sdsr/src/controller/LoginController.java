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
@WebServlet({"/LoginIngreso","/Recuperacion","/CerrarSesion"})
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/CerrarSesion")){
			cerrarSesion(request,response);
		}
	}

	private void cerrarSesion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			session.removeAttribute("user");
			session.removeAttribute("cliente");
			session.removeAttribute("lista");
			session.invalidate();
			String pageToForward = request.getContextPath();
			response.sendRedirect(pageToForward);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		
	}

	private void recuperacion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("correo");
			LoginModel model = new LoginModel();
			Usuario usu = model.validaremail(email);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", usu);
			model.mandarEmail(email);
			request.setAttribute("mensaje", "Correo Enviado");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Recuperacion.jsp");
		rd.forward(request, response);
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user1 = request.getParameter("usuario");
			String pass1 = request.getParameter("contrasenia");
			LoginModel model = new LoginModel();
			ClienteModel model1 =  new ClienteModel(); 
			Usuario usu1 = model.validarusuariocontraseņa(user1, pass1);
			Cliente cli1 = model1.getCliente(user1);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", usu1);
			session.setAttribute("cliente", cli1);
			request.setAttribute("mensaje", "Dar Click para continuar");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginRegistro.jsp");
		rd.forward(request, response);
		
	}

}
