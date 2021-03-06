<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Register</h2>

<form action="ControladorCRUDMenu?action=regresar" method="post">
			<div>
    			<input type="submit" class="btn btn-success btn-lg" value="Cancelar" name="regresar" />
			</div>
</form>		
            
<form method="post" action="RegisterRController" onsubmit="return validate();">
               
    Nombre              <input type="text" name="txt_firstname" id="fname"></br></br>
    Apellido Paterno    <input type="text" name="txt_lastname" id="lname"></br></br>
    ApellidoMaterno     <input type="text" name="txt_lastnamem" id="lmname"></br></br>
    Email               <input type="text" name="txt_email" id="ename"></br></br>
    Password            <input type="password" name="txt_password" id="password"></br></br>
    Email Administrador <input type="text" name="txt_emailAdmin" id="enameadmin"></br></br>
                
    <input type="submit" name="btn_register" value="Register">
                            
</form>
</body>
</html>