package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteModel;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/Registro")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/Registro")){
			registro(request,response);
		}
	}

	private void registro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			String dni = request.getParameter("dni");
			String nomcliente = request.getParameter("nombre");
			String direccioncliente = request.getParameter("direccion");
			String emailcliente = request.getParameter("correo");
			Date fechanac = formato.parse(request.getParameter("fecnac").toString());
			String telefono = request.getParameter("telefono");
			String usuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("contrasenia");
			ClienteModel model = new ClienteModel();
			model.insertaUsuario(dni, nomcliente, direccioncliente, emailcliente, fechanac, telefono, usuario, contrasenia);
			request.setAttribute("mensaje", "Se Realizo el Registro con Exito");
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("Registro.jsp");
		rd.forward(request, response);
		
	}

}
