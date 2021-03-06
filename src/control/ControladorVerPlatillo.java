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
import dao.PlatilloDAO;
import modelo.Carrito;
import modelo.Pedidos;
import modelo.Platillo;

@WebServlet("/ControladorVerPlatillo")
public class ControladorVerPlatillo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	PlatilloDAO platilloDAO;
	Platillo p = new Platillo();
	float total;
	Carrito car = null;
	ArrayList<Platillo> lista = new ArrayList<Platillo>();
	PedidosDAO pedidoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			platilloDAO = new PlatilloDAO(jdbcURL, jdbcUsername, jdbcPassword);
			pedidoDAO = new PedidosDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			System.out.println("excepcion ver platillo: "+e);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorVerPlatillo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet...VerPlatillo");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "mostrar":
				System.out.println("mostrar Platillos");
				mostrar(request, response);
				break;
			case "agregar":
				System.out.println("agregar platillo");
				agregar(request,response);
				break;
			case "eliminar":
				System.out.println("eliminar platillo");
				eliminarDeCarrito(request,response);
				break;
			case "carrito":
				System.out.println("ver carrito");
				carrito(request,response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			System.out.println("execption ver platillo: "+e);
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		System.out.println("Mostrando el menu al cliente");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/VerPlatilloCliente.jsp");
		List<Platillo> listaArticulos = platilloDAO.listarPlatillos();
		request.setAttribute("cliente", request.getParameter("cliente"));
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}
	
	private void agregar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		System.out.println("jeje");
		int idp = Integer.parseInt(request.getParameter("idPlatillo"));
		//String cliente = request.getParameter("cliente");
		p = platilloDAO.obtenerPorId(idp);
		lista.add(p);
		//request.setAttribute("usuario", cliente);
		System.out.println("Aqui mori");
		mostrar(request, response);
	}
	private void carrito(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/VerCarrito.jsp");
		total=0.0f;
		String cliente= request.getParameter("cliente");
		for(int i = 0; i< this.lista.size(); ++i) {
			total+=this.lista.get(i).getPrecio();
		}
		int idPedido = pedidoDAO.asignarIDPedido(cliente, this.lista);
		
		request.setAttribute("idPedido", idPedido);
		request.setAttribute("cliente", cliente);
		request.setAttribute("carrito", this.lista);
		request.setAttribute("total", total);
		dispatcher.forward(request, response);
	}
	
	private void eliminarDeCarrito(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/VerCarrito.jsp");
		int idp = Integer.parseInt(request.getParameter("id"));
		Platillo p = platilloDAO.obtenerPorId(idp);
		for(int i=0; i<lista.size();i++) {
			if(p.getId()==lista.get(i).getId()) {
				lista.remove(i);
			}
		}
		total=0.0f;
		for(int i = 0; i< lista.size(); ++i) {
			total+=lista.get(i).getPrecio();
		}
		//request.setAttribute("idPedido", pedidoDAO.asignarIDPedido(cliente, this.lista));
		String cliente = request.getParameter("cliente");
		int idPedido = pedidoDAO.asignarIDPedido(cliente, this.lista);
		request.setAttribute("cliente", cliente);
		request.setAttribute("idPedido", idPedido);
		request.setAttribute("carrito", this.lista);
		request.setAttribute("total", total);
		dispatcher.forward(request, response);
		
	}
		

}
