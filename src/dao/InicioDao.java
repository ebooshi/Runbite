package dao;

import modelo.ModeloInicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InicioDao 
{
    public String authorizeLogin(ModeloInicio loginBean) //create authorizeLogin()function
    {
        String email=loginBean.getEmail(); //get username value through loginBean object and store in temporary variable "username"
        String password=loginBean.getPassword(); //get password value through loginBean object and store in temporary variable "password"
        
        String dbemail="";  //create two variable for use next process
        String dbpassword="";
        
        String url="jdbc:mysql://localhost:3306/ingenieria"; //database connection url string
        String uname="admin"; //database username
        String pass="admin"; //database password
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con = DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt = con.prepareStatement("select * from Cliente where correoC=? and contrasenna=?"); //sql select query 
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery(); //execute query and set in Resultset object rs.
            
            //Se forza a buscar en la tabla cliente
            while(rs.next())
            {    
                dbemail=rs.getString("correoC");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
                dbpassword=rs.getString("contrasenna"); 
                
                if(email.equals(dbemail) && password.equals(dbpassword))  //apply if condition check for fetchable database username and password are match for user input side type in textbox
                {
                    return "SUCCESS LOGIN"; //if valid condition return string "SUCCESS LOGIN" 
                }//Tal vez aui pueda buscar en las demás tablas :v
            } 
            pstmt.close(); //close statement
            con.close(); //close connection
        }catch(Exception e){
            e.printStackTrace();
        }
        
     // Se forza a buscar en la tabla repartidor
        try{
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection conRepartidor = DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmtRepartidor = null; //create statement
            
            pstmtRepartidor = conRepartidor.prepareStatement("select * from Repartidor where correoR=? and contrasenna = ?"); //sql select query 
            pstmtRepartidor.setString(1,email);
            pstmtRepartidor.setString(2,password);
            ResultSet rsRepartidor = pstmtRepartidor.executeQuery(); //execute query and set in Resultset object rs.
            
            while(rsRepartidor.next())
            {    
                dbemail = rsRepartidor.getString("correoR");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
                dbpassword = rsRepartidor.getString("contrasenna"); 
                
                if(email.equals(dbemail) && password.equals(dbpassword))  //apply if condition check for fetchable database username and password are match for user input side type in textbox
                {
                    return "SUCCESS LOGIN REPARTIDOR"; //if valid condition return string "SUCCESS LOGIN" 
                }//Tal vez aui pueda buscar en las demás tablas :v
            } 
            pstmtRepartidor.close(); //close statement
            conRepartidor.close(); //close connection
        }catch(Exception e){
            e.printStackTrace();
        }
        
     // Se forza a buscar en la tabla administrador
        try{
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection conAdmin = DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmtAdmin = null; //create statement
            
            pstmtAdmin = conAdmin.prepareStatement("select * from Administrador where correoA=? and contrasenna = ?"); //sql select query 
            pstmtAdmin.setString(1,email);
            pstmtAdmin.setString(2,password);
            ResultSet rsAdmin = pstmtAdmin.executeQuery(); //execute query and set in Resultset object rs.
            
            while(rsAdmin.next())
            {    
                dbemail = rsAdmin.getString("correoA");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
                dbpassword = rsAdmin.getString("contrasenna"); 
                
                if(email.equals(dbemail) && password.equals(dbpassword))  //apply if condition check for fetchable database username and password are match for user input side type in textbox
                {
                    return "SUCCESS LOGIN ADMINISTRADOR"; //if valid condition return string "SUCCESS LOGIN" 
                }//Tal vez aui pueda buscar en las demás tablas :v
            } 
            pstmtAdmin.close(); //close statement
            conAdmin.close(); //close connection
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return "WRONG USERNAME AND PASSWORD"; //if invalid condition return string "WRONG USERNAME AND PASSWORD"
    }
}