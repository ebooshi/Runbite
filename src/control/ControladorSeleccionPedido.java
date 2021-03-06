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
 * Servlet implementation class ControladorSeleccionPedido
 */
@WebServlet("/controladorSeleccionPedido")
public class ControladorSeleccionPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidosDAO pedidoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			pedidoDAO = new PedidosDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorSeleccionPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HolaServlet...Seleccion");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				System.out.println("index sw");
				break;
			case "rep":
				mostrarPedidoRepartidor(request,response);
				System.out.println("rep Mos sw seleccion");
				break;
			case "agregar":
				agregarPedidoApedidosDelRepartidor(request, response);
				System.out.println("agregando pedido");
				break;
			
			default:
				System.out.println("default sw");
				break;
			}			
		} catch (SQLException e) {
			System.out.println("excepcion seleccion: "+e+"\n action = "+action);
			e.getStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet....dp2");
		doGet(request, response);
	}
	public void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	public void mostrarPedidoRepartidor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/agregarPedidoSeleccionado.jsp");
		List<Pedidos> pedidos= pedidoDAO.getPedidosConEstadoListo();
		List<Float> total = new ArrayList<Float>();
		for(int i=0;i<pedidos.size();i++) {
			total.add(pedidoDAO.getTotal(pedidos.get(i).getId()));
		}
		request.setAttribute("total", total);
		request.setAttribute("listaRep", pedidos);
		dispatcher.forward(request, response);
	}

	public List<Pedidos> agregarSeleccionados(List<Pedidos> selecionados) {
		
		List<Pedidos> pedidos = selecionados;
		return pedidos;
		
	}
	
	public void agregarPedidoApedidosDelRepartidor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		System.out.println("agre");
		int id = Integer.parseInt(request.getParameter("id"));
		String rep = request.getParameter("repartidor");
		String estado = "En Proceso"; 
		Pedidos seleccionado = pedidoDAO.obtenerPorIdPedido(id);
		pedidoDAO.agregarPedidosSeleccionadosPorRepartidor(id, rep, estado);
		mostrarPedidoRepartidor(request,response);
	}
	
	
	
	
}
