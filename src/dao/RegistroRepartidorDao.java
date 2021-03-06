package dao;

import modelo.ModeloRegistroRepartidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistroRepartidorDao {
	
    public String authorizeRegister(ModeloRegistroRepartidor registerBean) //create authorizeRegister()function
    {
        String firstname=registerBean.getFirstname();
        String lastname=registerBean.getLastname();
        String lastnamem=registerBean.getLastnameMaterno();
        String email=registerBean.getEmail();  //get all value through registerBean object and store in temporary variable
        String password=registerBean.getPassword();
        String correoAdmin = registerBean.getEmailAdmin();
        
        String url="jdbc:mysql://localhost:3306/ingenieria"; //database connection url string
        String uname="admin"; //database username
        String pass="admin"; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into Repartidor(nombres,APaterno,AMaterno,correoR,contrasenna, correoA) values(?,?,?,?,?,?)"); //sql insert query
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setString(3,lastnamem);
            pstmt.setString(4,email);
            pstmt.setString(5,password); 
            pstmt.setString(6, correoAdmin);
            pstmt.executeUpdate(); //execute query
             
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
            return "SUCCESS REGISTER"; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
        	System.out.println("falle");
            e.printStackTrace();
        }
            return "FAIL REGISTER"; //if invalid return string "FAIL REGISTER"
    }
}

 