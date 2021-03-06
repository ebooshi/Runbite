package modelo;

public class Cliente {
    private String nombre;
    private String correo;
    private String contrasenna;
    private Direccion direccion;
    
    public Cliente(String nombre, String correo, String contrasenna, Direccion direccion) {
    	this.nombre = nombre;
    	this.correo = correo;
    	this.contrasenna = contrasenna;
    	this.direccion = direccion;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return this.contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

}