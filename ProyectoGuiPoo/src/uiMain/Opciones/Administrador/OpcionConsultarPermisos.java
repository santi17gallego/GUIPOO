package uiMain.Opciones.Administrador;

import gestorAplicacion.paquete1.Administrador;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarPermisos extends OpcionDeMenu {
    public OpcionConsultarPermisos() {
        super("Consultar permisos de usuario.");
    }
    @Override
    public void ejecutar() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese cedula del usuario:");
        String cedula=sc.nextLine();
        String Lista[]=((Administrador)sesion).consultarPermisos(cedula);
        if(Lista==null){
            System.out.println("Error, no se pudo realizar la acción.");
        }else{
            System.out.println("\nPermisos:");
            for (String item : Lista) {
                System.out.println("-"+item);
            }
        }
    }
    
}
