package modelo;
import modelo.Platillo;
import java.util.ArrayList;

public class Pedidos {

    private int id;
  	private String calle;
    private String numero;
    private String ciudad;
    private String municipio;
    private String cp;
    private String destinatario;
    private String estado;
    private float total;
    private ArrayList<Platillo> platillos;    
    private Platillo platillo;

    public Pedidos(int id, String calle, String numero, String ciudad,
                    String municipio, String destinatario,
                    String estado, ArrayList<Platillo> platillos){
    	this.id=id;
    	this.calle=calle;
    	this.numero=numero;
    	this.ciudad=ciudad;
    	this.municipio=municipio;
    	this.destinatario=destinatario;
    	this.estado=estado;
    	this.platillos=platillos;
    }
    
    public Pedidos(int id, String calle, String numero, String ciudad,
            String municipio, String destinatario,
            String estado){
    		this.id=id;
			this.calle=calle;
			this.numero=numero;
			this.ciudad=ciudad;
			this.municipio=municipio;
			this.destinatario=destinatario;
			this.estado=estado;
}
    
    
    public void setTotal(float total) {
    	this.total=total;
    }
    public int getId(){
      return id;
    }
   	public String getCalle(){
   		return calle;
   	}
   	public String getNumero(){
   		return numero;
   	}
   	public String getCiudad(){
   		return ciudad;
   	}
   	public String getMunicipio(){
   		return municipio;
   	}
   	public String getCp(){
   		return cp;
   	}
   	public String getDestinatario(){
   		return destinatario;
   	}
   	public String getEstado(){
   		return estado;
   	}
   	public Platillo getPlatillo(){
   		return platillo;
   	}
    public void setId(int id){
      this.id=id;
    }
   	public void setCalle(String calle){
   		this.calle=calle;
   	}
   	public void setNumero(String numero){
   		this.numero=numero;
   	}
   	public void setCiudad(String ciudad){
   		this.ciudad=ciudad;
   	}
   	public void serMunicipio(String municipio){
   		this.municipio=municipio;
   	}
   	public void setCp(String cp){
   		this.cp=cp;
   	}
   	public void setDestinatario(String destinatario){
   		this.destinatario=destinatario;
   	}
   	public void setMunicipio(String municipio) {
   		this.municipio=municipio;
   	}
   	public void setEstado(String estado){
   		this.estado=estado;
   	}
   	public void setPlatillo(Platillo platilllo){
   		this.platillo=platilllo;
   	}
   	public float getTotal(){
   	
   		return total;
   		
   	}
    public Platillo getPlatilloI(int i ){
      return  platillos.get(i);
    } 
    
    public ArrayList<Platillo> getPlatillos(){
      return  platillos;
    }

    public String imprime() {
    	String cad ="";
    	cad += "Direccion: \n";
    	cad += "\n\t\t Calle: "+this.getCalle();
    	cad += "\n\t\t Numero: "+this.getNumero();
    	cad += "\n\t\t Ciudad: "+this.getCiudad();
    	cad += "\n\t\t Municipio: "+this.getMunicipio();
    	cad += "\n\t\t Destinatario: "+this.getDestinatario();
    	return cad;

    }
    
}
