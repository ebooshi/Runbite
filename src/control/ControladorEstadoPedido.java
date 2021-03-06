package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidosDAO;
import modelo.Pedidos;
import modelo.Platillo;


/**
 * Servlet implementation class ControladorEstadoPedido
 */
@WebServlet("/controladorEstadoPedido")
public class ControladorEstadoPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidosDAO pedidoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			pedidoDAO = new PedidosDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {

			System.out.println("init Estado: "+e);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorEstadoPedido() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HolaServlet...1");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				System.out.println("index EstadoPedido");
				break;
			case "actualizarPedidoAdmin":
				actualizarEstadoPedidoAdmin(request, response);
				System.out.println("actualizarEstado Admin sw");
				break;
			case "actualizarEstadoRep":
				actualizarEstadoPedidoRepartidor(request,response);
				System.out.println("actualizarEstado Repartidor sw");
				break;
			case"admin":
				mostrarPedidoAdmin(request,response);
				System.out.println("admind Mos sw EstadoPedido");
				break;
			case "platos":
				mostrarListaPlatillos(request,response);
				
				System.out.println("platos sw estado");
				break;
			case "rep":
				mostrarPedidoRepartidor(request,response);
				System.out.println("rep Mos sw");
				break;
			case "porIdPla":
				getPorIdPlatillo(request,response);
				System.out.println("por id platillo estado");
				break;
			default:
				System.out.println("default sw EstadoPedido");
				break;
			}			
		} catch (SQLException e) {
			System.out.println("Estado: "+e);
			e.getStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet....dp1");
		doGet(request, response);
	}
	public void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/welcomeAdministrador.jsp");
		dispatcher.forward(request, response);
	}
	
	public void mostrarPedidoAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/MostrarPedidoAdmin.jsp");
		
		List<Pedidos> listaPedidos= pedidoDAO.listarPedidos();
		List<Float> total = new ArrayList<Float>();
		for(int i=0; i<listaPedidos.size();i++) {
			total.add(pedidoDAO.getTotal(listaPedidos.get(i).getId()));
		}
		request.setAttribute("total", total);
		request.setAttribute("lista", listaPedidos);
		dispatcher.forward(request, response);
	}
	
	
	public void mostrarListaPlatillos(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mostrarPlatillos.jsp");
		int idPedido = Integer.parseInt(request.getParameter("idPedido"));
		List<Integer> idplatillos = pedidoDAO.getIdsPlatillosEnPedido(idPedido);
		request.setAttribute("platillos", idplatillos);
		dispatcher.forward(request, response);
	}
	public void getPorIdPlatillo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/mostrarPlatillos1.jsp");
		Platillo p = pedidoDAO.obtenerPorIdPlatillo(Integer.parseInt(request.getParameter("idPlatillo")));
		request.setAttribute("p",p);
		dispatcher.forward(request, response);
	}
	public void mostrarPedidoRepartidor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/MostrarPedidoRepartidor.jsp");

		String correoR = request.getParameter("repartidor");
		List<Pedidos> pedidos = pedidoDAO.getPedidosConEstadoEnProceso(correoR); 		
		List<Float> total = new ArrayList<Float>();
		for(int i=0;i<pedidos.size();i++) {
			total.add(pedidoDAO.getTotal(pedidos.get(i).getId()));
		}
		request.setAttribute("total", total);
		request.setAttribute("listaRep", pedidos);
		dispatcher.forward(request, response);
	 
	}
	
	
	public void actualizarEstadoPedidoAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String estado = request.getParameter("ESTADO");
		System.out.println("id: "+id);
		System.out.println("estado: "+estado);
		pedidoDAO.actualizarEstadoPedido(id, estado);
		mostrarPedidoAdmin(request, response);
		
	}
	
	public void actualizarEstadoPedidoRepartidor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String estado = request.getParameter("ESTADO");
		System.out.println("id: "+id);
		System.out.println("estado: "+estado);
		pedidoDAO.actualizarEstadoPedido(id, estado);
		mostrarPedidoRepartidor(request, response);
	}
}

