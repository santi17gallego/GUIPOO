package BaseDatos;

import Excepciones.CedulaOContrasenaInvalida;
import gestorAplicacion.paquete1.Administrador;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
import gestorAplicacion.paquete1.Vendedor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorUsuario {
    
    //Objetos que utilizaremos para gestionar los archivos de texto
    
    private static File file = new File("C:\\GUIPOO\\ProyectoGuiPoo\\src\\BaseDatos\\temp\\usuarios.txt");
    private static File file2 = new File("C:\\GUIPOO\\ProyectoGuiPoo\\src\\BaseDatos\\temp\\permisos.txt");
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static FileReader fr = null;
    private static FileWriter fw = null;
    private static PrintWriter pw = null;

    public static boolean RegistrarUsuario(Usuario usuario) {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            
            if (usuario instanceof Cliente) {
                String menu = "permisos ConsultarPesoIdeal ConsultarCaloriasQuemadas";
                Cliente cliente = (Cliente) usuario;
                pw.println("cliente " + usuario.getCedula() + " " + usuario.getNombre() + " " + usuario.getContrasena() + " "
                        + (int) cliente.getEdad() + " " + cliente.getPeso() + " " + cliente.getEstatura() + " " + cliente.getGenero() + " " + cliente.getTelefono() + " " + menu); //Se registra un cliente en el txt
            } else if (usuario instanceof Vendedor) {
                String menu = "permisos ConsultarInventario";
                pw.println("vendedor " + usuario.getCedula() + " " + usuario.getNombre() + " " + usuario.getContrasena() + " " + menu);
            } else if (usuario instanceof Instructor) {
                String menu = "permisos ConsultarDieta ConsultarRutina";
                pw.println("instructor " + usuario.getCedula() + " " + usuario.getNombre() + " " + usuario.getContrasena() + " " + menu);
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }

    public static Object[] IniciarSesion(String cedula, String contrasena) throws CedulaOContrasenaInvalida{
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String lines = "";
            Object lista[] = null;
            while ((lines = br.readLine()) != null) { //Leemos linea por linea el archivo de texto
                String cadena[] = lines.split(" "); //Cada linea es un usuario y los datos están separados por un espacio
                if (cadena[1].equals(cedula)) {
                    if (cadena[3].equals(contrasena)) {
                        lista = new Object[2];
                        if ("cliente".equals(cadena[0])) {
                            Cliente cliente=new Cliente(cadena[2], cedula, contrasena);
                            cliente.setPeso(Float.parseFloat(cadena[5]));
                            cliente.setGenero(cadena[7]);
                            cliente.setEstatura(Float.parseFloat(cadena[6]));
                            cliente.setEdad(Integer.parseInt(cadena[4]));
                            cliente.setTelefono(cadena[8]);
                            
                            lista[0] = cliente;
                            
                            lista[1] = lines.substring(lines.indexOf("permisos") + 9).split(" ");
                        } else if ("admin".equals(cadena[0])) {
                            lista[0] = new Administrador(cadena[2], cedula, contrasena);
                            lista[1] = lines.substring(lines.indexOf("permisos") + 9).split(" ");
                        } else if ("instructor".equals(cadena[0])) {
                            lista[0] = new Instructor(cadena[2], cedula, contrasena);
                            lista[1] = lines.substring(lines.indexOf("permisos") + 9).split(" ");
                        } else if ("vendedor".equals(cadena[0])) {
                            lista[0] = new Vendedor(cadena[2], cedula, contrasena);
                            lista[1] = lines.substring(lines.indexOf("permisos") + 9).split(" ");
                        }
                        break;
                    }
                }
            }
            br.close();
            fr.close();
            
            if(lista==null){
                throw new CedulaOContrasenaInvalida();
            }
            return lista;
        } catch (IOException | NumberFormatException e) {
            return null;
        }
    }

    public static String[] ConsultarPermisos(String cedula) {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String respuesta[] = null;
            String lines = "";
            while ((lines = br.readLine()) != null) {
                String cadena[] = lines.split(" ");
                if (cadena[1].equals(cedula)) {
                    respuesta = lines.substring(lines.indexOf("permisos") + 9).split(" ");
                    break;
                }
            }
            br.close();
            fr.close();
            return respuesta;
        } catch (Exception e) {
            return null;
        }

    }

    public static String ConsultarPermisos() {
        try {
            fr = new FileReader(file2);
            br = new BufferedReader(fr);
            String lines = "", cadena = "";
            while ((lines = br.readLine()) != null) {
                String line[]=lines.split(" ");
                cadena = cadena + "*" + line[0] + ":\n";
                for (int i = 1; i < line.length; i++) {
                    cadena = cadena + "-" + line[i] + "\n";
                }
            }
            br.close();
            fr.close();
            return cadena;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean EliminarUsuario(String cedula) {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "", lines = "";
            while ((line = br.readLine()) != null) {
                String cadena[] = line.split(" ");
                if (!cadena[1].equals(cedula)) {
                    lines = lines + line + "\n";
                }
            }
            br.close();
            fr.close();
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.print(lines);
            pw.close();
            bw.close();
            fw.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static Cliente ConsultarCliente(String cedula) {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String lines = "";
            Cliente cliente = null;
            while ((lines = br.readLine()) != null) {
                String cadena[] = lines.split(" ");
                if (cadena[1].equals(cedula)) {
                    cliente = new Cliente(cedula, cadena[2], null, Integer.parseInt(cadena[4]), Float.parseFloat(cadena[5]), Float.parseFloat(cadena[6]), cadena[7], null);
                    break;
                }
            }
            br.close();
            fr.close();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static boolean ModificarUsuario(Usuario usuario) {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "", lines = "", permisos=" ";
            while ((line = br.readLine()) != null) {
                String cadena[] = line.split(" ");
                if (cadena[1].equals(usuario.getCedula())) {
                    permisos=permisos+line.substring(line.indexOf("permisos"));
                }else{
                    lines = lines + line + "\n";
                }
            }
            br.close();
            fr.close();
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.print(lines);
            if(usuario instanceof Cliente){
                Cliente cliente = (Cliente)usuario;
                pw.print("cliente "+cliente.getCedula()+" "+cliente.getNombre()+" "+cliente.getContrasena()+" "+
                        cliente.getEdad()+" "+cliente.getPeso()+" "+cliente.getEstatura()+" "+cliente.getGenero()+" "+cliente.getTelefono()+permisos);
            }else if(usuario instanceof Administrador){
                pw.print("admin "+usuario.getCedula()+" "+usuario.getNombre()+" "+usuario.getContrasena()+permisos);
            }
            pw.print("\n");
            pw.close();
            bw.close();
            fw.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
