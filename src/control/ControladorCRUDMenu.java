package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlatilloDAO;
import modelo.Platillo;


@WebServlet("/ControladorCRUDMenu")
public class ControladorCRUDMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PlatilloDAO platilloDAO;
	private int auxiliar;
       
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			platilloDAO = new PlatilloDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	

    public ControladorCRUDMenu() {
        super();
        // TODO Auto-generated constructor stub
        this.auxiliar = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("Hola Servlet..");
		System.out.println(action);
		try {
			switch (action) {
			case "agregar":
				agregar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "registrarRepartidor":
				registrarRepartidor (request, response);
				break;
			case "estado":
				estado(request, response);
				break;
			case "regresar":
				regresar(request, response);
				break;
			case "TRANSREGISTER":
				TRANSREGISTER(request, response);
				break;
			case "TRANSEDITAR":
				TRANSEDITAR(request, response);
				break;
			case "showedit":
				showEditar(request, response);
			break;
			case "eliminar":
				eliminar (request, response);
			break;
			case "ver":
				ver (request, response);
			break;
			case "salir":
				salir (request, response);
			break;
		} 
	}catch (SQLException e) {
			e.getStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void agregar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/administradorCrearPlatillo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/menuAdministrador.jsp");
		List<Platillo> listaArticulos= platilloDAO.listarPlatillos();
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}
	
	private void registrarRepartidor (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/registraRepartidor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void estado (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/jsp/MostrarPedidoAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	 private void regresar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("jsp/welcomeAdministrador.jsp");
		dispatcher.forward(request, response);
	}
	 
    private void salir (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void TRANSREGISTER (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		Platillo platillo = new Platillo(request.getParameter("field1"), request.getParameter("field3"), Float.parseFloat(request.getParameter("field2")), auxiliar++);
		platilloDAO.insertar(platillo);
		//System.out.println(request.getParameter("field2"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/welcomeAdministrador.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Platillo platillo = platilloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("platillo", platillo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/administradorEditarPlatillo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Platillo platillo = platilloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		System.out.println("Se detuvo?");
		platilloDAO.eliminar(platillo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/welcomeAdministrador.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void ver(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Platillo platillo = platilloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("platillo", platillo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/administradorVistaPlatillo.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void TRANSEDITAR(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Platillo platillo = new Platillo(request.getParameter("nombre"), request.getParameter("descripcion"), Float.parseFloat(request.getParameter("precio")),Integer.parseInt(request.getParameter("id")));
		platilloDAO.actualizar(platillo);
		RequestDispatcher dispatcher= request.getRequestDispatcher("jsp/welcomeAdministrador.jsp");
		dispatcher.forward(request, response);
	}
	
	
}