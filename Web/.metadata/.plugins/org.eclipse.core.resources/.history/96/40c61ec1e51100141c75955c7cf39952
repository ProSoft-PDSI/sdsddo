package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PagosModel;

/**
 * Servlet implementation class PagosController
 */
@WebServlet("/Pago")
public class PagosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/Pago")){
			pagar(request,response);
		}
	}
	
	private void pagar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			//Session
			HttpSession session=request.getSession();
			
			//Datos
			//String nropedido = (request.getParameter("td_pedido")).replaceAll(" ", "");//
			String nropedido=(String) session.getAttribute("nropedido");
			String codtipo_pago=(request.getParameter("hid_tipo_pago")).replaceAll(" ", "");
			Double totalpedido=Double.parseDouble((String) session.getAttribute("totalpedido"));//
			Double efectivo=Double.parseDouble(request.getParameter("imp_efec"));
			Double cambio=Double.parseDouble(request.getParameter("hid_cambio"));//
			String estado="P";
			String usuario=request.getParameter("hid_usuario");
			
			//Proceso
			PagosModel model= new PagosModel();
			model.InsertarPago(nropedido, codtipo_pago, totalpedido, efectivo, cambio, estado, usuario);
			out.print("Proceso OK.");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print(e.getMessage());
		}finally{
			out.close();
		}
	}

}
