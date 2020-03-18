package uiMain.Opciones;

import gestorAplicacion.paquete1.Cliente;
import java.util.Scanner;
import uiMain.menuConsola.MenuDeConsola;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionRegistrarse extends OpcionDeMenu {

    @Override
    public void ejecutar() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre=sc.nextLine();
        System.out.println("Ingrese cedula:");
        String cedula=sc.nextLine();
        System.out.println("Ingrese contraseña:");
        String contra=sc.nextLine();
        System.out.println("Ingrese telefono:");
        String telefono=sc.nextLine();
        System.out.println("Ingrese peso(en kilogramos):");
        float peso=Float.parseFloat(sc.nextLine());
        System.out.println("Ingrese estatura (en metros, ejemplo: 1.56):");
        float estatura=Float.parseFloat(sc.nextLine());
        System.out.println("Ingrese edad:");
        int edad=Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese genero (m para masculino, f para femenino):");
        String genero=sc.nextLine();
        System.out.println("¡Bienvenid@ a BodyArt!\n"
                + "Para ver las opciones de menú por favor elija la opción salir y después ingrese "
                + "por medio de la opción ingresar.");
        
        boolean accion= Cliente.registrarse(new Cliente(cedula, nombre, contra, edad, peso, estatura, genero, telefono));
        if(!accion){
            System.out.println("Error, no se pudo realizar la acción.");
//            MenuDeConsola.lanzarMenu();
        }else{
//            MenuDeConsola.sesion=new Cliente(nombre, cedula, contra);
            String lista[]= {"Cliente-ConsultarPesoIdeal", "Cliente-ConsultarCaloriasQuemadas", "Cliente-InscribirEvento", "*-RegistrarSugerencia"};
            MenuDeConsola.crearMenu(lista);
        }
    }
    
}
