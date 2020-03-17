package uiMain.Opciones.Administrador;

import gestorAplicacion.paquete1.Administrador;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionEliminarUsuario extends OpcionDeMenu {

    public OpcionEliminarUsuario() {
        super("Eliminar usuario.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc= new Scanner(System.in);
        System.out.println("\nIngrese cédula:");
        String cedula = sc.nextLine();
        if(!((Administrador)sesion).eliminarUsuario(cedula)){
            System.out.println("Error, no se pudo realizar la acción.");
        }
    }
    
}
