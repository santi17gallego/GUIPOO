package uiMain.menuConsola;

import gestorAplicacion.paquete1.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import uiMain.Opciones.OpcionIniciarSesion;
import uiMain.Opciones.OpcionRegistrarse;

public class MenuDeConsola {

    public static ArrayList<OpcionDeMenu> listaMenu = new ArrayList<OpcionDeMenu>();

    public static Usuario sesion;

    public static void lanzarMenu() {
        if (sesion == null) {
            System.out.println("\nIngrese una opción.");
            System.out.print("0 Ingresar\n1 Registrarse\n2 Ver información del proyecto\n");
            short opcion = -1;
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextShort();
            if (opcion == 0) {
                new OpcionIniciarSesion().ejecutar();
            } else if (opcion == 1) {
                new OpcionRegistrarse().ejecutar();
            } else if (opcion == 2) {
                System.out.println("\nEl proyecto consiste en la sistematización de los procesos que se realizan en un gimnasio.\n"
                        + "el gimnasio cuenta con procesos como:\n"
                        + "*Venta de servicios y productos.\n"
                        + "*Eventos.\n"
                        + "*Gestión de usuario (cliente, vendedor, instructor).");
                System.out.println("\nAutores:\n"
                        + "Santiago López Gallego\n"
                        + "Juan Camilo Hoyos Peña\n"
                        + "Jean Carlo herrera Delgado\n"
                        + "Juan Camilo Muñoz López");
                lanzarMenu();
            } else {
                lanzarMenu();
            }
        } else {
            do {
                System.out.println("\nIngrese una opción.");
                short opcion = -1;
                int i = 0;
                for (i = 0; i < listaMenu.size(); i++) {
                    System.out.println(i + " " + listaMenu.get(i).getNombre());
                }
                System.out.println(i + " Salir");
                Scanner sc = new Scanner(System.in);
                opcion = Short.parseShort(sc.nextLine());
                if (opcion >= 0 && opcion <= listaMenu.size() - 1) {
                    listaMenu.get(opcion).ejecutar();
                }
                if (opcion == i) {
                    break;
                }
            } while (true);
            cerrarSesion();
        }
    }

    public static void cerrarSesion() {
        MenuDeConsola.listaMenu = new ArrayList<OpcionDeMenu>();
        MenuDeConsola.sesion = null;
        lanzarMenu();
    }

    public static void crearMenu(String lista[]) {
        try {
            for (String item : lista) {
                String item1[] = item.split("-");
                String paquete = item1[0];
                String clase = item1[1];
                listaMenu.add((OpcionDeMenu) Class.forName("uiMain.Opciones." + ("*".equals(paquete) ? "": paquete+".") + "Opcion" + clase).newInstance());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //lanzarMenu();
    }
}
