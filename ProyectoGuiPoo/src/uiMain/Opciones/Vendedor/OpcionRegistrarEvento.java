package uiMain.Opciones.Vendedor;

import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Evento;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionRegistrarEvento extends OpcionDeMenu {
    public OpcionRegistrarEvento() {
        super("Registrar evento.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre del evento:");
        String actividad = sc.nextLine();
        System.out.println("Ingrese horario (ejemplo Lunes-8:30):");
        String horario = sc.nextLine();
        System.out.println("Ingrese número de cupos:");
        int numeroDeCupos = sc.nextInt();
        if (!((Vendedor)sesion).registrarEvento(new Evento(actividad, horario, numeroDeCupos))) {
            System.out.println("Error, no se pudo realizar la acción.");
        }
    }
}
