package uiMain.Opciones.Vendedor;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Factura;
import java.util.ArrayList;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarVentas extends OpcionDeMenu {

    public OpcionConsultarVentas() {
        super("Consultar ventas.");
    }
    
    @Override
    public void ejecutar() {
        ArrayList<Factura> lista= ((Vendedor)sesion).consultarVentas();
        if(lista==null || lista.isEmpty()){
            System.out.println("Error, no se pudo realizar la acción.");
        }else{
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Venta #"+i);
                Factura factura=lista.get(i);
                Cliente cliente =factura.getCliente();
                Vendedor vendedor =factura.getVendedor();
                System.out.println("Cliente : "+cliente.getCedula()+" "+cliente.getNombre());
                System.out.println("Vendedor : "+vendedor.getCedula()+" "+vendedor.getNombre());
                System.out.println("Fecha : "+factura.getFecha());
                System.out.println("Productos : "+factura.getProductos().replaceAll("-", " "));
                System.out.println("Precio total : "+factura.getPrecioTotal());
            }
        }
    }
    
}
