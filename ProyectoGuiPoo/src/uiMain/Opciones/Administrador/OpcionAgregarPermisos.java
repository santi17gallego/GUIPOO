package uiMain.Opciones.Administrador;

import gestorAplicacion.paquete1.Administrador;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionAgregarPermisos extends OpcionDeMenu {

    public OpcionAgregarPermisos() {
        super("Agregar permisos a usuario.");
    }

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese cédula:");
        String cedula = sc.nextLine();
        
        Administrador admin=(Administrador)sesion;
        
        String permisosDis[]=admin.consultarPermisosPorTipo(cedula);
        System.out.println("\nPermisos disponibles para este usuario:");
        for (int i = 0; i < permisosDis.length; i++) {
            System.out.println(i+" "+permisosDis[i]);
        }
        
        System.out.println("Ingrese # permisos a agregar en una linea separados por espacios:");
        String opciones[] = sc.nextLine().split(" ");
        String arrayPermisos[] = new String[opciones.length];
        for (int i = 0; i < opciones.length; i++) {
            arrayPermisos[i]=permisosDis[Integer.parseInt(opciones[i])];
        }
        if(!admin.agregarPermisos(cedula, arrayPermisos)){
            System.out.println("Error, no se pudo realizar la acción.");
        }
    }
}
