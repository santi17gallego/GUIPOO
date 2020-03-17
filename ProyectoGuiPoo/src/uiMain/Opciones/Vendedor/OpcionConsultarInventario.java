package uiMain.Opciones.Vendedor;

import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Suplemento;
import java.util.ArrayList;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarInventario extends OpcionDeMenu{
    
    public OpcionConsultarInventario() {
        super("Consultar inventario.");
    }

    @Override
    public void ejecutar() {
        ArrayList<Suplemento> lista= ((Vendedor)sesion).consultarInventario();
        if(lista==null || lista.isEmpty()){
            System.out.println("Error, no se pudo realizar la acción.");
        }else{
            System.out.println("Inventario disponible:\n");
            for (Suplemento suplemento : lista) {
                System.out.println("- Nombre: "+suplemento.getNombre()+", precio: "+suplemento.getPrecio()+", descripción: "+suplemento.getDescripcion());
            }
        }
    }
    
}
