package uiMain.Opciones.Instructor;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarTmb extends OpcionDeMenu {
    
    public OpcionConsultarTmb() {
        super("Consultar tasa de masa basal.");
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
            System.out.println("Calculando tasa metabólica basal de "+(cliente.getNombre()));
            float tmb = instructor.calcularTmb(cliente);
            System.out.println("\nNombre del cliente: " + cliente.getNombre() + "\n"
                    + "Edad: " + cliente.getEdad() + "\n"
                    + "Peso: " + cliente.getPeso() + "\n"
                    + "Estatura: " + cliente.getEstatura() + "\n"
                    + "Tmb: " + tmb);
        }
    }
    
}
