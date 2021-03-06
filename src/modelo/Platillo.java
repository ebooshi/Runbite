package modelo;

/*Clase utilizada en el modelo para crear un Objeto Platillo*/
public class Platillo {

    private String nombre; 
    private String descripcion;
    private float precio;
    private int cantidad;
    private int id;
    
    
    public Platillo(String nombre, String descripcion, float precio, int id) {
    	this.nombre = nombre;
    	this.descripcion = descripcion;
       	this.precio = precio;
    	this.id = id;
    }
    
    public Platillo(String nombre, String descripcion, float precio, int cantidad, int id){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.id = id;
    }
    
    public Platillo(int id, String nombre, String descripcion, float precio){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.id = id;
    }
    
    public Platillo(String nombre, float precio, String descripcion){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    public Platillo() {
    	
    }
    
	public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public int getCantidad(){
        return cantidad;
    }

  
    public float getPrecio() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.precio;
    }

    public void setPrecio(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.precio = value;
    }

    public String getNombre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombre;
    }

    public void setNombre(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombre = value;
    }

    public String getDescripcion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.descripcion;
    }

    public void setDescripcion(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.descripcion = value;
    }
    
    public int getId() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.id;
    }

    public void setId(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.id = value;
    }

}
