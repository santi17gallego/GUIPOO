package uiMain.Opciones.Instructor;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarDieta extends OpcionDeMenu {
    public OpcionConsultarDieta() {
        super("Consultar dieta.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese cedula del cliente:");
        String cedula = sc.nextLine();
        System.out.println("\nIngrese cantidad de ejercicio (si es poco: 2 o menos días (digite 1)\nSi es ligero: 3 días (digite 2)\nSi es moderado: 3-5 días (digite 3)\nSi es deportista: 6-7 días (digite 4)\nSi es atleta: 7 días mañana y tarde (digite 5):");
        String cantidad = sc.nextLine();
        
        Instructor instructor = ((Instructor) sesion);
        Cliente cliente = instructor.consultarCliente(cedula);
        if (cliente == null) {
            System.out.println("Error, no se pudo realizar la acción.");
        } else {
            String descrip = instructor.calcularDieta(cliente,cantidad);
            System.out.println("Creando una buena dieta para "+(cliente.getNombre()));
            System.out.println("\nNombre del cliente: " + cliente.getNombre() + "\n"
                    + "Rutina: " + descrip);
        }
    }
    
}
