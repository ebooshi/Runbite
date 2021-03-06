package modelo;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Platillo> listaPlatillo;
    
    public Carrito(ArrayList<Platillo> listaPlatillo){
        this.listaPlatillo = listaPlatillo;
    }
    
    public void annadir(Platillo p) {
    	this.getListaPlatillo().add(p);
    }
    
    public String prueba(String p) {
    	return p;
    }
    
    public float calcularTotal() {
    	if(this.listaPlatillo.isEmpty()) return 0;
    	float total = 0f;
        Platillo pl;
    	for(int i = 0; i< this.listaPlatillo.size(); ++i) {
            pl = this.listaPlatillo.get(i);
    		total += pl.getPrecio()*pl.getCantidad();
    	}
        return total;
    }
    
    public boolean agregarPlatillo(Platillo platillo){
        return true;
    }

    public boolean eliminarPlatillo() {
        return true;
    }

    public ArrayList<Platillo> getListaPlatillo() {
        return this.listaPlatillo;
    }

    public void setListaPlatillo(ArrayList<Platillo> listaPlatillo) {
        this.listaPlatillo = listaPlatillo;
    }
    
}
