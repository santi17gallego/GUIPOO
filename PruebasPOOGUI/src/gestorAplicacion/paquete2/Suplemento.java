package gestorAplicacion.paquete2;


public class Suplemento extends ProductoServicio{
    
   private String descripcion; //cantidad calorias


   
   //CONSTRUCTOR
   
   public Suplemento(String nombrep, double precio) {
        super(nombrep, precio);
        
   }
   public Suplemento(String nombrep, double precio, String descripcion ){
       this(nombrep, precio);
       this.descripcion=descripcion;
       
   }

   public String getDescripcion() {
        return descripcion;
   }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
     
    
}
