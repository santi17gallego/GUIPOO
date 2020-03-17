package uiMain.Opciones.Cliente;

import gestorAplicacion.paquete1.Cliente;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarPesoIdeal extends OpcionDeMenu {

    public OpcionConsultarPesoIdeal() {
        super("Consultar peso ideal.");
    }

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese estatura en metros:");
        float estatura = Float.parseFloat(sc.nextLine());
        ((Cliente) sesion).pesoIdeal(estatura);
    }
}
