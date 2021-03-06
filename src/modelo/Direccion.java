package modelo;

public class Direccion {
		private String calle;
	    private String numero;
	    private String estado;
	    private String cp;
	    
	    public Direccion(String calle, String numero, String estado, String cp) {
	    	this.calle = calle;
	    	this.numero = numero;
	    	this.estado = estado;
	    	this.cp = cp;
	    }
	    
	    public String getCalle() {
	        return this.calle;
	    }

	    public void setCalle(String value) {
	        this.calle = value;
	    }

	    public String getNumero() {
	        return this.numero;
	    }

	    public void setNumero(String value) {
	        this.numero = value;
	    }

	    public String getEstado() {
	        return this.estado;
	    }

	    public void setEstado(String value) {
	        this.estado = value;
	    }

	    public String getCP() {
	        return this.cp;
	    }

	    public void setCP(String cp) {
	        this.cp = cp;
	    }

}