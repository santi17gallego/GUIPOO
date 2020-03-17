package uiMain.Opciones.Vendedor;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Factura;
import gestorAplicacion.paquete2.Suplemento;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionRegistrarVenta extends OpcionDeMenu {

    public OpcionRegistrarVenta() {
        super("Registrar venta.");
    }

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese cedula del cliente:");
        Vendedor vendedor = ((Vendedor) sesion);
        Cliente cliente = vendedor.consultarCliente(sc.nextLine());
        if (cliente == null) {

        } else {
            ArrayList<Suplemento> lista = vendedor.consultarInventario();
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + " " + lista.get(i).getNombre());
            }
            System.out.println("Ingrese # de productos a vender con espacio intermedio de un espacio:");
            String cadena[] = sc.nextLine().split(" ");
            String productos = "";
            double precioDeVenta=0;
            for (int i = 0; i < cadena.length; i++) {
                Suplemento producto=lista.get(Integer.parseInt(cadena[i]));
                productos = productos + producto.getNombre() + "-";
                precioDeVenta=precioDeVenta+producto.getPrecio();
            }
            productos = productos.substring(0, productos.length() - 1);

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            //System.out.println(formatter.format(calendar.getTime()));
            if (!vendedor.registrarVenta(new Factura(formatter.format(calendar.getTime()), vendedor, cliente, precioDeVenta,productos))) {
                System.out.println("Error, no se pudo realizar la acción.");
            }
        }
    }

}
