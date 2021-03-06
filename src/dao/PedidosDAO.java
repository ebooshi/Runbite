package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ConexionBD;
import modelo.Direccion;
import modelo.Pedidos;
import modelo.Platillo;

public class PedidosDAO {

	private static ConexionBD con;
	private static Connection connection;
	
	public PedidosDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public List<Pedidos> listarPedidos() throws SQLException {
		System.out.println("listar Pedidos");
		List<Pedidos> listaPedidos = new ArrayList<Pedidos>();
		String sql = "SELECT * FROM Pedido";
		System.out.println(sql);
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while(resulSet.next()) {
			int id = resulSet.getInt("IDPedido");
			String calle = resulSet.getString("calle");
			String numero = resulSet.getString("numero");
			String ciudad = resulSet.getString("ciudad");
			//String cp = resulSet.getString("cp");
			String destinatario=resulSet.getString("destinatario");		
			String municipio = resulSet.getString("municipio");
			String estado = resulSet.getString("estado"); 
			Pedidos pedido = new Pedidos(
									id, 
									calle, 
									numero, 
									ciudad, 
									destinatario, 
									municipio, 
									estado
									);
			listaPedidos.add(pedido);
		}	
		con.desconectar();
		
		System.out.println("Cerrada listar Pedidos");
		return listaPedidos;
	}
	
	public List<Pedidos> getPedidosConEstadoListo()throws SQLException {
		List<Pedidos> listaPedidos = new ArrayList<Pedidos>();
		String sql = "SELECT * FROM Pedido WHERE estado = ? ";
		con.conectar();
		connection=con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "Listo");
		ResultSet resulSet = statement.executeQuery();
		while(resulSet.next()) {
			int id = resulSet.getInt("IDPedido");
			String calle = resulSet.getString("calle");
			String numero = resulSet.getString("numero");
			String ciudad = resulSet.getString("ciudad");
			//String cp = resulSet.getString("cp");
			String destinatario=resulSet.getString("destinatario");		
			String municipio = resulSet.getString("municipio");
			String estado = resulSet.getString("estado"); 
			Pedidos pedido = new Pedidos(
									id, 
									calle, 
									numero, 
									ciudad, 
									destinatario, 
									municipio, 
									estado
									);
			listaPedidos.add(pedido);
			
		}
		return listaPedidos;
		
	}
	
	public List<Pedidos> getPedidosConEstadoEnProceso(String correoR)throws SQLException {
		List<Pedidos> listaPedidos = new ArrayList<Pedidos>();
		String sql = "SELECT (`IDPedido`) FROM entrega WHERE correoR = ? ";
		con.conectar();
		connection=con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, correoR);
		ResultSet resulSet = statement.executeQuery();
		List<Integer> idPedidos = new ArrayList<Integer>();
		while(resulSet.next()) {
			idPedidos.add(resulSet.getInt("IDPedido"));
			
		}
		for(int i=0; i<idPedidos.size();i++) {
			listaPedidos.add(this.obtenerPorIdPedido(idPedidos.get(i)));
		}
		return listaPedidos;
		
	}	
	
	public List<Pedidos> getPedidosConEstadoEnProceso()throws SQLException {
		List<Pedidos> listaPedidos = new ArrayList<Pedidos>();
		String sql = "SELECT * FROM Pedido WHERE estado = ? ";
		con.conectar();
		connection=con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "En Proceso");
		ResultSet resulSet = statement.executeQuery();
		while(resulSet.next()) {
			int id = resulSet.getInt("IDPedido");
			String calle = resulSet.getString("calle");
			String numero = resulSet.getString("numero");
			String ciudad = resulSet.getString("ciudad");
			//String cp = resulSet.getString("cp");
			String destinatario=resulSet.getString("destinatario");		
			String municipio = resulSet.getString("municipio");
			String estado = resulSet.getString("estado"); 
			Pedidos pedido = new Pedidos(
									id, 
									calle, 
									numero, 
									ciudad, 
									destinatario, 
									municipio, 
									estado
									);
			listaPedidos.add(pedido);
			
		}
		return listaPedidos;
		
	}
	
	public Pedidos obtenerPorIdPedido(int id) throws SQLException {
		Pedidos pedido = null;
		String sql = "SELECT * FROM Pedido WHERE IDPedido = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			pedido = new Pedidos(
				res.getInt("IDPedido"),
				res.getString("calle"), 
				res.getString("numero"),
				res.getString("ciudad"),
				res.getString("municipio"),
				res.getString("destinatario"),
				res.getString("estado"));
			
		}
		res.close();
		System.out.println("Cerrado porIDPedido");
		con.desconectar();
		return pedido;
	}
		
	public List<Platillo> listarPlatillosEnPedido(int idPedido) throws SQLException {
		List<Platillo> listaPlatillos = new ArrayList<Platillo>();
		String sql = "select (`IDPlatillo`) from tener where `IDPedido`= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idPedido);
		ResultSet res = statement.executeQuery();
		while(res.next()) {
			System.out.println("IDPlatillo: "+res.getInt("IDPlatillo"));
			listaPlatillos.add(obtenerPorIdPlatillo(res.getInt("IDPlatillo")));
		}
		return listaPlatillos;
	}
	
	public List<Integer> getIdsPlatillosEnPedido(int idPedido) throws SQLException {
		List<Integer> idsPlatillos = new ArrayList<Integer>();
		String sql = "select (`IDPlatillo`) from tener where `IDPedido`= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idPedido);
		ResultSet res = statement.executeQuery();
		while(res.next()) {
			System.out.println("IDPlatillo: "+res.getInt("IDPlatillo"));
			idsPlatillos.add(res.getInt("IDPlatillo"));
		}
		
		return idsPlatillos;
	}
	
	public List<Integer> getIdsPedidosEnEntrega() throws SQLException {
		List<Integer> idsPlatillos = new ArrayList<Integer>();
		String sql = "select (`IDPedido`) from entrega ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet res = statement.executeQuery();
		while(res.next()) {
			idsPlatillos.add(res.getInt("IDPedido"));
		}
		return idsPlatillos;
	}

	public Platillo obtenerPorIdPlatillo(int id) throws SQLException {
		Platillo platillo = null;
		String sql = "SELECT * FROM Platillo WHERE IDPlatillo = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			platillo = new Platillo(
				res.getInt("IDPlatillo"),
				res.getString("nombre"),
				res.getString("descripcion"), 
				Float.parseFloat(res.getString("precio"))
				);
		}
		res.close();
		System.out.println("Cerrado porIDPlatillo");
		con.desconectar();
		return platillo;
	}
	
	public float getTotal(int idPedido) throws SQLException{
		float total = 0f;
		List<Integer> IdsPlatillos = this.getIdsPlatillosEnPedido(idPedido);
		for(int i =0; i<IdsPlatillos.size(); i++) {
			Platillo p = this.obtenerPorIdPlatillo(IdsPlatillos.get(i));
			total += p.getPrecio();
		}
		return total;
		
	}

	public boolean actualizarDireccion(String calle, String numero, String ciudad, String municipio, String destinatario, int idPedido) throws SQLException {
		Pedidos p = this.obtenerPorIdPedido(idPedido);
		p.setCalle(calle);
		p.setNumero(numero);
		p.setCiudad(ciudad);
		p.setMunicipio(municipio);
		p.setDestinatario(destinatario);
		boolean rowActualizar = false;
		String sql = "UPDATE Pedido SET municipio=?,numero=?,calle=?,ciudad=?,destinatario=? WHERE IDPedido=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, p.getMunicipio());
		statement.setString(2, p.getNumero());
		statement.setString(3, p.getCalle());
		statement.setString(4, p.getCiudad());
		statement.setString(5, p.getDestinatario());
		statement.setInt(6, idPedido);
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		System.out.println("calle : "+p.getCalle());
		con.desconectar();
		return rowActualizar;

	}

	public boolean agregarPedidosSeleccionadosPorRepartidor(int id, String correoR, String estado) throws SQLException {
		boolean rowActualizar = false;
		
		String sql = "insert into Entrega (correoR, IDPedido) values (?,?);";
		String sql1 = "Update Pedido SET estado=? WHERE IDPedido=?";
		con.conectar();
		connection = con.getJdbcConnection() ;
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement1 = connection.prepareStatement(sql1); 
		statement.setString(1, correoR);
		statement.setInt(2, id);
		statement1.setString(1, estado);
		statement1.setInt(2, id);
		rowActualizar= statement.executeUpdate() > 0;
		rowActualizar= statement1.executeUpdate() > 0; 
		statement.close();
		statement1.close();
		System.out.println("Fue asignado al repartidor con correoC: "+correoR);
		con.desconectar();
		System.out.println("cerrado agregar: "+rowActualizar );
		return rowActualizar;
	}
	
	public Cliente obtenerPorCorreoC(String correoC) throws SQLException {
		Cliente cliente= null;
		Direccion direc = null;
		String sql = "SELECT * FROM Cliente WHERE correoC = ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, correoC);
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			direc = new Direccion(
					res.getString("calle"),
					res.getString("numero"),
					res.getString("estado"),
					res.getString("cp")
					);
					
			cliente = new Cliente(
					res.getString("nombres") +" "+ res.getString("APaterno")+" "+ res.getString("AMaterno"),
					res.getString("correoR"),
					res.getString("contrasenna"),
					direc
					);
		}
		res.close();
		System.out.println("El Cliente se obtuvo");
		con.desconectar();
		return cliente;
	}
	
	public boolean actualizarEstadoPedido(int id, String estado) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Pedido SET estado=? WHERE IDPedido=?";
		Pedidos p = this.obtenerPorIdPedido(id);
		p.setEstado(estado);
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, p.getEstado());
		statement.setInt(2, p.getId());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		System.out.println("estado actualizado");
		con.desconectar();
		System.out.println("cerrado actualizar actualizar estado: "+rowActualizar);
		return rowActualizar;
	}
	
	public int pedidoMax() throws SQLException {
		int pedido = 0;
		String sql ="select max(`IDPedido`) as total from Pedido;";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statment = connection.prepareStatement(sql);
		ResultSet res = statment.executeQuery();
		if(res.next()) {
		pedido = res.getInt("total");
		}
		res.close();
		System.out.println("El id pedido max es "+pedido);
		con.desconectar();
		return pedido;
	}
	
	public int asignarIDPedido(String correoC, List<Platillo> lista) throws SQLException{
	
		boolean asignar = false;
		int pedido = pedidoMax()+1; 
		String sql = "insert into Pedido (IDPedido,municipio,estado,numero,calle,ciudad,destinatario,correoC) values (?,?,?,?,?,?,?,?);";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, pedido);
		statement.setString(2,"");
		statement.setString(3, "");
		statement.setString(4, "");
		statement.setString(5, "");
		statement.setString(6, "");
		statement.setString(7, "");
		statement.setString(8, correoC);
		
		asignar = statement.executeUpdate() > 0;
		System.out.println("Agignar = " +asignar);
		statement.close();
		con.desconectar();
		System.out.println("Pedido creado con el ID" + pedido);
		System.out.println("Pedido creado con el ID" + pedido+ "Row :" +asignar);
		for(int i = 0; i< lista.size(); ++i) {
			System.out.println("Objeto: " + lista.get(i).getNombre());
			actualizaTener(lista.get(i).getId(),pedido);
		}
		
		return pedido;
	}
	
	public boolean actualizaTener(int IDPlatillo, int IDPedido) throws SQLException {
		boolean actualiza = false;
		String sql = "insert into tener (IDPedido,IDPlatillo) values (?,?);";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, IDPedido);
		statement.setInt(2, IDPlatillo);
		actualiza = statement.executeUpdate() > 0;
		statement.close();
		System.out.println("Se asigno el pedido con ID"+ IDPedido + " y el platillo con ID "+ IDPlatillo);
		con.desconectar();
		return actualiza;
	}
}
