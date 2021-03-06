package dao;

import modelo.ModeloRegistro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistroDao {
	
    public String authorizeRegister(ModeloRegistro registerBean) 
    {
        String firstname=registerBean.getFirstname();
        String lastname=registerBean.getLastname();
        String lastnamem=registerBean.getLastnameMaterno();
        String email=registerBean.getEmail();  
        String password=registerBean.getPassword();
        
        String url="jdbc:mysql://localhost:3306/ingenieria"; // conexión a la base de datos
        String uname="admin"; //usuario de la base de datos 
        String pass="admin"; // contraseña para entrar a la base de datos
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into Cliente(nombres,APaterno,AMaterno,correoC,contrasenna) values(?,?,?,?,?)"); //sql insert query
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setString(3,lastnamem);
            pstmt.setString(4,email);
            pstmt.setString(5,password); 
            pstmt.executeUpdate(); //execute query
             
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
            return "SUCCESS REGISTER"; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL REGISTER"; //if invalid return string "FAIL REGISTER"
    }
}
