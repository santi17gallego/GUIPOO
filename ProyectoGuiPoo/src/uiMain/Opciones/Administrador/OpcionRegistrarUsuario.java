package uiMain.Opciones.Administrador;

import gestorAplicacion.paquete1.Administrador;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Vendedor;
import java.util.Scanner;
import uiMain.menuConsola.MenuDeConsola;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionRegistrarUsuario extends OpcionDeMenu {
    
    public OpcionRegistrarUsuario() {
        super("Registrar usuario.");
    }
    
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese tipo de usuario:\n0 Cliente\n1 Vendedor\n2 Instructor");
        short tipoUsuario = Short.parseShort(sc.nextLine());
        boolean accion=false;
        switch (tipoUsuario) {
            case 0:
                {
                    System.out.println("Ingrese nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese cedula:");
                    String cedula = sc.nextLine();
                    System.out.println("Ingrese contraseña:");
                    String contra = sc.nextLine();
                    System.out.println("Ingrese telefono:");
                    String telefono = sc.nextLine();
                    System.out.println("Ingrese peso (en kilogramos):");
                    float peso = Float.parseFloat(sc.nextLine());
                    System.out.println("Ingrese estatura (en metros, ejemplo: 1.56):");
                    float estatura = Float.parseFloat(sc.nextLine());
                    System.out.println("Ingrese edad:");
                    int edad = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese genero (m para masculino, f para femenino):");
                    String genero = sc.nextLine();
                    accion = ((Administrador)sesion).registrarUsuario(new Cliente(cedula, nombre, contra, edad, peso, estatura, genero, telefono));
                    break;
                }
            case 1:
                {
                    System.out.println("Ingrese nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese cedula:");
                    String cedula = sc.nextLine();
                    System.out.println("Ingrese contraseña:");
                    String contra = sc.nextLine();
                    accion = ((Administrador)sesion).registrarUsuario(new Vendedor(nombre, cedula, contra));
                    break;
                }
            case 2:
                {
                    System.out.println("Ingrese nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese cedula:");
                    String cedula = sc.nextLine();
                    System.out.println("Ingrese contraseña:");
                    String contra = sc.nextLine();
                    accion = ((Administrador)sesion).registrarUsuario(new Instructor(nombre, cedula, contra));
                    break;
                }
            default:
                this.ejecutar();
                break;
        }
        if(!accion){
            System.out.println("Error, no se pudo realizar la acción.");
        }
        MenuDeConsola.lanzarMenu();
    }

}
