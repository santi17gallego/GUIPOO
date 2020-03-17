package uiMain.Opciones.Instructor;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarEstadoActual extends OpcionDeMenu{
    
    public OpcionConsultarEstadoActual() {
        super("Consultar estado actual.");
    }

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese cedula del cliente:");
        String cedula = sc.nextLine();
        Instructor instructor = ((Instructor) sesion);
        Cliente cliente = instructor.consultarCliente(cedula);
        if (cliente == null) {
            System.out.println("Error, no se pudo realizar la acción.");
        } else {
            System.out.println("Calculando el estado actual de "+(cliente.getNombre()));
            String estado = instructor.estadoActual(cliente);
            System.out.println("\nNombre del cliente: " + cliente.getNombre() + "\n"
                    + "Peso: " + cliente.getPeso() + "\n"
                    + "Estado: " + estado);
        }
    }
    
}
