package control;

import modelo.ModeloInicio;
import dao.InicioDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("ControladorInicio")
public class ControladorInicio extends HttpServlet 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_login")!=null) //check button click event not null from login.jsp page button
        {
            String username=request.getParameter("txt_username"); //get textbox name "txt_username"
            String password=request.getParameter("txt_password"); //get textbox name "txt_password"
            
            ModeloInicio loginBean=new ModeloInicio(); //this class contain seeting up all received values from index.jsp page to setter and getter method for application require effectively 
            
            loginBean.setUsername(username); //set username through loginBean object
            loginBean.setPassword(password); //set password through loginBean object
            
            InicioDao loginDao=new InicioDao(); //this class contain main logic to perform function calling and database operation
            
            String authorize=loginDao.authorizeLogin(loginBean); //send loginBean object values into authorizeLogin() function in LoginDao class
            
            if(authorize.equals("SUCCESS LOGIN")) //check calling authorizeLogin() function receive string "SUCCESS LOGIN" message after continue process
            {
            	HttpSession session=request.getSession(); //session is created
                session.setAttribute("login",loginBean.getEmail()); //session name is "login" and  store username in "getUsername()" get through loginBean object
                request.setAttribute("usuario", username);
                RequestDispatcher rd=request.getRequestDispatcher("/jsp/welcome.jsp"); //redirect to welcome.jsp page
                rd.forward(request, response);
            
            }else if(authorize.equals("SUCCESS LOGIN REPARTIDOR")) {
            	HttpSession session=request.getSession(); //session is created
                session.setAttribute("login",loginBean.getEmail()); //session name is "login" and  store username in "getUsername()" get through loginBean object
                request.setAttribute("usuario", username);
                RequestDispatcher rd=request.getRequestDispatcher("/jsp/welcomeRepartidor.jsp"); //redirect to welcome.jsp page
                rd.forward(request, response);
            
            }else if(authorize.equals("SUCCESS LOGIN ADMINISTRADOR")) {
            	HttpSession session=request.getSession(); //session is created
                session.setAttribute("login",loginBean.getEmail()); //session name is "login" and  store username in "getUsername()" get through loginBean object
                RequestDispatcher rd=request.getRequestDispatcher("/jsp/welcomeAdministrador.jsp"); //redirect to welcome.jsp page
                rd.forward(request, response);
                
            }else{
                request.setAttribute("WrongLoginMsg",authorize); //wrong login error message is "WrongLoginMsg"
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); //show error same index.jsp page
                rd.include(request, response);
            }
        }
    }

}