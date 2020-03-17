package uiMain.Opciones;

import gestorAplicacion.paquete1.Usuario;
import java.util.Scanner;
import uiMain.menuConsola.MenuDeConsola;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionIniciarSesion extends OpcionDeMenu {

    @Override
    public void ejecutar() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese cedula:");
        String cedula=sc.nextLine();
        System.out.println("Ingrese contraseña:");
        String contra=sc.nextLine();
        Object [] lista =Usuario.iniciarSesion(cedula, contra);        
        if(lista== null){
            System.out.println("Error al iniciar sesión");
            MenuDeConsola.lanzarMenu();
        }else{
            MenuDeConsola.sesion=(Usuario)lista[0];
            MenuDeConsola.crearMenu((String [])lista[1]);
        }
    }
    
}
