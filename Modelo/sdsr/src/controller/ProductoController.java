package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductoModel;
import entity.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/Menu")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/Menu")){
			try {
				Menu(request,response);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			}
		}
	}

	private void Menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoModel model = new ProductoModel();
			List<Producto> menu = model.getMenu();
			request.setAttribute("menu", menu);
			//request.getHeader("referer");
			
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
