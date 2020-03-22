package gestorAplicacion.paquete1;

import BaseDatos.GestorEvento;
import BaseDatos.GestorSugerencia;
import BaseDatos.GestorUsuario;
import BaseDatos.GestorVendedor;
import gestorAplicacion.paquete2.*;
import java.util.ArrayList;


public class Vendedor extends Usuario implements Sugerencia{
    
    //CONSTRUCTOR
    public Vendedor(String nombre, String cedula, String contrasena) {
        super(nombre, cedula, contrasena);
    }
    
    public Vendedor(){}
    //MÉTODOS CONCRETOS
    public boolean registrarVenta(Factura factura){ 
        return GestorVendedor.RegistrarVenta(factura);
    }

    @Override
    public boolean comentar(String comentario) {
        return GestorSugerencia.RegistrarSugerencia(comentario);
    }
    
    public ArrayList<Suplemento> consultarInventario() {
        return GestorVendedor.ConsultarInventario();
    }
    
    public ArrayList<Factura> consultarVentas() {
        return GestorVendedor.ConsultarVentas();
    }
    
    public boolean registrarEvento(Evento evento) {
        return GestorEvento.RegistrarEvento(evento);
    }
  
    public boolean registrarProducto(Suplemento suplem) {
        return GestorVendedor.RegistrarProducto(suplem);
    }
    
    public Cliente consultarCliente(String cedula){
        return GestorUsuario.ConsultarCliente(cedula);
    }
}