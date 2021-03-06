package controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cliente;
import entity.DetallePedido;
import entity.Pedido;
import entity.Usuario;
import model.ControlModel;
import model.PedidosModel;
import model.ProductoModel;

@WebServlet({"/InsertarPedido","/EliminarPedido","/ModificarPedido","/ListaPedidos","/Entrada","/Pizza","/Especiales","/InsertaLista"})
public class PedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<DetallePedido> listapedido = new Vector<DetallePedido>();   

    public PedidosController() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/Entrada")){
			EntradaPost(request,response);
		}else if(alias.equals("/Pizza")){
			PizzaPost(request,response);
		}else if(alias.equals("/Especiales")){
			EspecialesPost(request,response);
		}else if(alias.equals("/InsertarPedido")){
			InsertarPedido(request,response);
		}
    }


	private void EspecialesPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoModel model = new ProductoModel();
			request.setAttribute("listaespecial", model.getEspeciales());
			
			HttpSession session = request.getSession(true);
			String codProducto = (String) request.getParameter("codigo");
			int cantidad = Integer.parseInt((String)request.getParameter("cant"));
			DetallePedido bean = new DetallePedido();
			ControlModel model1 = new ControlModel();
			bean.setNropedido(model1.getValor("pedido"));
			bean.setCodproducto(codProducto);
			bean.setCant(cantidad);
			listapedido.add(bean);
			session.setAttribute("lista", listapedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Pedido.jsp");
		rd.forward(request, response);
		
	}

	private void PizzaPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductoModel model = new ProductoModel();
			request.setAttribute("listapizza", model.getPizza());
			request.setAttribute("listapizzaclasico", model.getPizzaClasico());
			
			HttpSession session = request.getSession(true);
			String codProducto = (String) request.getParameter("codigo");
			int cantidad = Integer.parseInt((String)request.getParameter("cant"));
			DetallePedido bean = new DetallePedido();
			ControlModel model1 = new ControlModel();
			bean.setNropedido(model1.getValor("pedido"));
			bean.setCodproducto(codProducto);
			bean.setCant(cantidad);
			listapedido.add(bean);
			session.setAttribute("lista", listapedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Pedido.jsp");
		rd.forward(request, response);
	}

	private void EntradaPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
		ProductoModel model = new ProductoModel();
		request.setAttribute("listaentrada", model.getEntrada());
		request.setAttribute("listaentradaclasico", model.getEntradaClasico());
		
		HttpSession session = request.getSession(true);
		String codProducto = (String) request.getParameter("codigo");
		int cantidad = Integer.parseInt((String)request.getParameter("cant"));
		DetallePedido bean = new DetallePedido();
		ControlModel model1 = new ControlModel();
		bean.setNropedido(model1.getValor("pedido"));
		bean.setCodproducto(codProducto);
		bean.setCant(cantidad);
		listapedido.add(bean);
		session.setAttribute("lista", listapedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Pedido.jsp");
		rd.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if(alias.equals("/ListaPedidos")){
				ListaPedidos(request,response);
		}else if(alias.equals("/Entrada")){
			Entrada(request,response);
		}else if(alias.equals("/Pizza")){
			Pizza(request,response);
		}else if(alias.equals("/Especiales")){
			Especiales(request,response);
		}
	}

	private void Especiales(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductoModel model = new ProductoModel();
		request.setAttribute("listaespecial", model.getEspeciales());
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Especiales.jsp");
		rd.forward(request, response);	
		
	}


	private void Pizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		ProductoModel model = new ProductoModel();
		request.setAttribute("listapizza", model.getPizza());
		request.setAttribute("listapizzaclasico", model.getPizzaClasico());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Clasica.jsp");
		rd.forward(request, response);
		
	}

	private void Entrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		ProductoModel model = new ProductoModel();
		request.setAttribute("listaentrada", model.getEntrada());
		request.setAttribute("listaentradaclasico", model.getEntradaClasico());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Entrada.jsp");
		rd.forward(request, response);
		
	}

	private void ListaPedidos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			session.getAttribute("lista");
			RequestDispatcher rd = request.getRequestDispatcher("Pedido.jsp");
			rd.forward(request, response);

	}

	private void InsertarPedido(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			try{
			HttpSession session = request.getSession(true);
				Cliente cli = (Cliente)session.getAttribute("cliente");
				Usuario usu = (Usuario)session.getAttribute("user");
				PedidosModel model = new PedidosModel();
				ControlModel model1 = new ControlModel();
				String codigo = model1.getValor("pedido");
				model.InsertarPedidos(cli.getDni(),usu.getUsuario());
				model.InsertaProductosDetallePedido(listapedido, usu.getUsuario());
				Pedido pedido = model.getPedido(codigo);
				session.setAttribute("nropedido",codigo);
				session.setAttribute("totalpedido", pedido.getTotalpedido());
				System.out.println(pedido.getTotalpedido());
				request.setAttribute("mensaje", "insercion Exitosa");
				session.removeAttribute("listapedido");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}		
			RequestDispatcher rd = request.getRequestDispatcher("Pagos.jsp");
			rd.forward(request, response);
	}

}
