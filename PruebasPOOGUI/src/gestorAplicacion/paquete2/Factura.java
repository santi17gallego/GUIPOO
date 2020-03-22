package gestorAplicacion.paquete2;
import gestorAplicacion.paquete1.*;   

public class Factura {
    
    public String fecha;
    private Vendedor vendedor;
    private Cliente cliente;
    private double precioTotal;
    private String productos;

    public double getPrecioTotal() {
        return precioTotal;
    }

    public String getProductos() {
        return productos;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
    
    
    //CONSTRUTOR
    public Factura(String fecha, Vendedor vendedor, Cliente cliente, double precioTotal, String productos){
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.precioTotal=precioTotal;
        this.productos=productos;
    }

    
    //SETTERS
  
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //GETTERS

    public String getFecha() {
        return fecha;
    }
    

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }
       
}
