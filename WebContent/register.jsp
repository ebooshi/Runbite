<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
<h2>Register</h2>
            
<form method="post" action="RegisterController" onsubmit="return validate();">
               
    Nombre              <input type="text" name="txt_firstname" id="fname"></br></br>
    Apellido Paterno    <input type="text" name="txt_lastname" id="lname"></br></br>
    ApellidoMaterno     <input type="text" name="txt_lastnamem" id="lmname"></br></br>
    Email               <input type="text" name="txt_email" id="ename"></br></br>
    Password            <input type="password" name="txt_password" id="password"></br></br>
                
    <input type="submit" name="btn_register" value="Register">
                
    <h3>You have a account? <a href="index.jsp">Login</a></h3>
                
</form>
</body>
</html>