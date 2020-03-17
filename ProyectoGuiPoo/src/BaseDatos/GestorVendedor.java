package BaseDatos;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Factura;
import gestorAplicacion.paquete2.Suplemento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GestorVendedor {

    private static File file = new File("C:\\ProyectoPOO\\ProyectoPOO\\src\\BaseDatos\\temp\\productos.txt");
    private static File file2 = new File("C:\\ProyectoPOO\\ProyectoPOO\\src\\BaseDatos\\temp\\ventas.txt");
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static FileReader fr = null;
    private static FileWriter fw = null;
    private static PrintWriter pw = null;
    
    public static boolean RegistrarVenta(Factura factura) {

        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fw = new FileWriter(file2, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(factura.getCliente().getCedula() + " " + factura.getCliente().getNombre() + " " + factura.getVendedor().getCedula()+" "+factura.getVendedor().getNombre()+" "+factura.getFecha()+" "+factura.getPrecioTotal()+" productos "+factura.getProductos());

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }
    
    public static boolean RegistrarProducto(Suplemento suplemento) {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(suplemento.getNombre() + " " + suplemento.getPrecio() + " " + suplemento.getDescripcion());

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }
    
    public static ArrayList<Factura> ConsultarVentas(){
        try {
            fr = new FileReader(file2);
            br = new BufferedReader(fr);
            String lines = "";
            ArrayList<Factura> lista= new ArrayList<Factura>();
            while ((lines = br.readLine()) != null) {
                String cadena[] = lines.split(" ");
                Cliente cliente= new Cliente();
                cliente.setCedula(cadena[0]);
                cliente.setNombre(cadena[1]);
                Vendedor vendedor= new Vendedor();
                vendedor.setCedula(cadena[2]);
                vendedor.setNombre(cadena[3]);
                lista.add(new Factura(cadena[4], vendedor, cliente, Double.parseDouble(cadena[5]), lines.substring(lines.indexOf("productos")+9)));
            }
            br.close();
            fr.close();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static ArrayList<Suplemento> ConsultarInventario(){
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String lines = "";
            ArrayList<Suplemento> lista= new ArrayList<Suplemento>();
            while ((lines = br.readLine()) != null) {
                String cadena[] = lines.split(" ");
                lista.add(new Suplemento(cadena[0], Double.parseDouble(cadena[1]), cadena[2]));
            }
            br.close();
            fr.close();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
