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
/**
 * Servlet implementation class ControlConfirmacionPedido
 */
@WebServlet("/controlConfPedido")
public class ControladorConfirmacionPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidosDAO pedidoDAO;
	

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			pedidoDAO = new PedidosDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorConfirmacionPedido() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HolaServlet...3");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				System.out.println("index Confirmacion sw");
				break;
			case "editar": 
			System.out.println("editar confirmacion sw");
				editarDireccion(request,response);
				break;
			case "shD":
				showEditarDireccion(request,response);
				System.out.println("shw edit confirmacion");
				break;
			case "detalles":
				detalles(request,response);
				System.out.println("detalles confirmacion sw");
				break;
			case "confirmar":
				confirmar(request,response);
				System.out.println("confirmar confirmacion sw");
				break;
			default:
				System.out.println("default Confirmacion sw");
				break;
			}			
		} catch (SQLException e) {
			System.out.println(e);
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola Servlet....ConfPedio");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void detalles(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String cliente= request.getParameter("cliente");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/detallesCompraIH.jsp");
		Pedidos pedido = pedidoDAO.obtenerPorIdPedido(Integer.parseInt(request.getParameter("id")));
		List<Float> total = new ArrayList<Float>();
		total.add(pedidoDAO.getTotal(pedido.getId()));
		request.setAttribute("cliente", cliente);
		request.setAttribute("total", total);
		request.setAttribute("detalles", pedido);
		dispatcher.forward(request, response);
	}

	private void confirmar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
	}

	private void showEditarDireccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String cliente= request.getParameter("cliente");
		request.setAttribute("cliente", cliente);
		System.out.println("Show editar");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/editarDireccion.jsp");
		Pedidos pedido = pedidoDAO.obtenerPorIdPedido(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("pedidoEditando", pedido);
		dispatcher.forward(request, response);
	}
	
	private void editarDireccion(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id editar: "+id);
		String calle = request.getParameter("calle");
		System.out.println("calle: "+calle);
		String numero = request.getParameter("numero");
		System.out.println("num: "+numero);
		String ciudad = request.getParameter("ciudad");
		String municipio = request.getParameter("municipio");
		//String cp = request.getParameter("cp");
		String destinatario = request.getParameter("destinatario");
		pedidoDAO.actualizarDireccion(calle, numero, ciudad, municipio,destinatario, id);
		detalles(request, response);
	}
	
}
