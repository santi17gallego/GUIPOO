package uiMain.Opciones.Cliente;

import gestorAplicacion.paquete1.Cliente;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarCaloriasQuemadas extends OpcionDeMenu {
    
    public OpcionConsultarCaloriasQuemadas() {
        super("Consultar calorias quemadas.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese distacia recorrida en km:");
        int km = Integer.parseInt(sc.nextLine());
        String response=((Cliente)sesion).calcularkcaloriasquemadas(km);
        System.out.println(response);
    }
    
}
