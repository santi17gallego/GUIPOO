package uiMain.Opciones;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Vendedor;
import java.util.Scanner;
//import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionRegistrarSugerencia extends OpcionDeMenu {

    public OpcionRegistrarSugerencia() {
        super("Registrar sugerencia.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese comentario:");
        String coment=sc.nextLine();
        boolean response=false;
//        if(sesion instanceof Cliente){
//            response=((Cliente)sesion).comentar(coment);
//        }else if(sesion instanceof Vendedor){
//            response=((Vendedor)sesion).comentar(coment);
//        }else if(sesion instanceof Instructor){
//            response=((Instructor)sesion).comentar(coment);
//        }
        if(!response){
            System.out.println("Error, no se pudo realizar la acción.");
        }
    }
    
}
