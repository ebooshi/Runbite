package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ConexionBD;
import modelo.Platillo;

public class PlatilloDAO {
	private ConexionBD con;
	private Connection connection;

	public PlatilloDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new ConexionBD(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar articulo
	public boolean insertar(Platillo platillo) throws SQLException {
		String sql = "INSERT INTO Platillo (nombre, descripcion, precio, IDPlatillo) VALUES (?, ?, ?, ?)";
		System.out.println("aaaa");
		System.out.println(platillo.getDescripcion());
		System.out.println("Preparando Query de insercion");
		con.conectar();
		connection = con.getJdbcConnection();
		System.out.println("Conectado");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, platillo.getNombre());
		statement.setString(2, platillo.getDescripcion());
		statement.setFloat(3, platillo.getPrecio());
		statement.setInt(4, platillo.getId());
		System.out.println("que onda");
		System.out.println(platillo.getDescripcion());
		System.out.println("insertado papu");
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		System.out.println("Insersión exitosa rey");
		return rowInserted;
	}

	// listar todos los productos
	public List<Platillo> listarPlatillos() throws SQLException {

		List<Platillo> listaPlatillos = new ArrayList<Platillo>();
		String sql = "SELECT * FROM Platillo";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			Float precio = resulSet.getFloat("precio");
			int id = resulSet.getInt("IDPlatillo");
			Platillo platillo = new Platillo(nombre, descripcion, precio,  id);
			listaPlatillos.add(platillo);
		}
		con.desconectar();
		return listaPlatillos;
	}

	// obtener por id
	public Platillo obtenerPorId(int id) throws SQLException {
		Platillo platillo = null;

		String sql = "SELECT * FROM Platillo WHERE IDPlatillo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			platillo = new Platillo(res.getString("nombre"), res.getString("descripcion"), res.getFloat("precio"), res.getInt("IDPlatillo"));
		}
		res.close();
		con.desconectar();

		return platillo;
	}

	// actualizar
	public boolean actualizar(Platillo platillo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Platillo SET nombre=?,descripcion=?, precio=? WHERE IDPlatillo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, platillo.getNombre());
		statement.setString(2, platillo.getDescripcion());
		statement.setFloat(3, platillo.getPrecio());
		statement.setInt(4, platillo.getId());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Platillo platillo) throws SQLException {
		System.out.println("Entrando a eliminar method");
		boolean rowEliminar = false;
		String sql = "DELETE FROM Platillo WHERE IDPlatillo=?";
		con.conectar();
		System.out.println("Entrando a eliminar method");
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, platillo.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}

}