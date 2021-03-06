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

import dao.impl.MensajeDaoImpl;
import dao.spec.MensajeDao;
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
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String dni = request.getParameter("dni");
			String nom = request.getParameter("nombre");
			String ape = request.getParameter("apellido");
			String nomcliente = nom + " " + ape;
			String direccioncliente = request.getParameter("direccion");
			String emailcliente = request.getParameter("correo");
			Date fechanac = formato.parse(request.getParameter("fecnac").toString());
			String telefono = request.getParameter("telefono");
			String usuario = request.getParameter("usuario");
			String contrasenia1 = request.getParameter("contrasenia1");
			String contrasenia2 = request.getParameter("contrasenia2");
			String contrasenia = contrasenia1;
			if(!contrasenia1.equals(contrasenia2) ){
				MensajeDao dao = new MensajeDaoImpl();
				throw new RuntimeException(dao.getMensaje("MEN005"));
			}
			ClienteModel model = new ClienteModel();
			model.insertaUsuario(dni, nomcliente, direccioncliente, emailcliente, fechanac, telefono, usuario, contrasenia);
			request.setAttribute("mensaje1", "Se Realizo el Registro con Exito");
		} catch (Exception e) {
			request.setAttribute("error1", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginRegistro.jsp");
		rd.forward(request, response);
		
	}

}
