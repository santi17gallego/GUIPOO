package gestorAplicacion.paquete2;

import java.util.*;

public abstract class ProductoServicio {//Esta clase abstracta cobija todos los productos y servicios que presta el gimnasio
    
    public String nombre; //hace referencia a si es proteína, caseina, o premium, black o basic
    double precio;
    
    //CONSTRUCTOR 

    public ProductoServicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
        
    }
    
    //SETTERS
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
}
