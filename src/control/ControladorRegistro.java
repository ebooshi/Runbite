package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRegistro;
import dao.RegistroDao;

public class ControladorRegistro extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        if(request.getParameter("btn_register")!=null) //check button click event not null from register.jsp page button
        {
            String firstname=request.getParameter("txt_firstname");
            String lastname=request.getParameter("txt_lastname");
            String lastnamem =request.getParameter("txt_lastnamem");
            String email=request.getParameter("txt_email");  //get all textbox name from register.jsp page
            String password=request.getParameter("txt_password");
            
            ModeloRegistro registerBean=new ModeloRegistro(); //this class contain  seeting up all received values from register.jsp page to setter and getter method for application require effectively
            
            registerBean.setFirstname(firstname);
            registerBean.setLastname(lastname);
            registerBean.setLastnameMaterno(lastnamem);
            registerBean.setEmail(email);  //set the all value through registerBean object
            registerBean.setPassword(password);
            
            RegistroDao registerdao=new RegistroDao(); //this class contain main logic to perform function calling and database operation
            
            String registerValidate=registerdao.authorizeRegister(registerBean); //send registerBean object values into authorizeRegister() function in RegisterDao class
            
            if(registerValidate.equals("SUCCESS REGISTER")) //check calling authorizeRegister() function receive "SUCCESS REGISTER" string message after redirect to index.jsp page
            {
                request.setAttribute("RegiseterSuccessMsg",registerValidate); //apply register successfully message "RegiseterSuccessMsg"
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); //redirect to index.jsp page
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("RegisterErrorMsg",registerValidate); // apply register error message "RegiseterErrorMsg"
                RequestDispatcher rd=request.getRequestDispatcher("register.jsp"); //show error same page register.jsp page
                rd.include(request, response);
            }
        }
    }

}
