package modelo;

public class ModeloRegistroRepartidor {

    private String firstname,lastname,lastnamematerno,email,password,emailAdmin;
    
    public String getFirstname(){
        return firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    
    public String getLastnameMaterno(){
        return lastnamematerno;
    }
    
    public void setLastnameMaterno(String lastnamematerno){
        this.lastnamematerno=lastnamematerno;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getEmailAdmin() {
    	return emailAdmin;
    }
    
    public void SetEmailAdmin(String emailAdmin) {
    	this.emailAdmin = emailAdmin;
    }

}
