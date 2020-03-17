package uiMain.Opciones.Vendedor;

import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Suplemento;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionRegistrarProducto extends OpcionDeMenu {
    
    public OpcionRegistrarProducto() {
        super("Registrar producto.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registrando producto.\n");
        System.out.println("Ingrese nombre del producto:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese precio del producto:");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Ingrese una breve descripción del producto:");
        String descr = sc.nextLine();
        if (!((Vendedor)sesion).registrarProducto(new Suplemento(nombre, precio, descr))) {
            System.out.println("Error, no se pudo realizar la acción.");
        }
    }

}
