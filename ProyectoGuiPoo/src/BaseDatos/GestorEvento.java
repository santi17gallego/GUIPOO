package BaseDatos;

import gestorAplicacion.paquete2.Evento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GestorEvento {

    private static File file = new File("C:\\GUIPOO\\ProyectoGuiPoo\\src\\BaseDatos\\temp\\eventos.txt");
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static FileReader fr = null;
    private static FileWriter fw = null;
    private static PrintWriter pw = null;

    public static ArrayList<Evento> ConsultarEventos() {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String lines = "";
            ArrayList<Evento> Eventos = new ArrayList<Evento>();
            while ((lines = br.readLine()) != null) {
                String cadena[] = lines.split(" ");
                if (cadena.length == 4) {
                    Eventos.add(new Evento(cadena[0], cadena[1], Integer.parseInt(cadena[2]), 0));
                } else {
                    String clientes[] = lines.substring(lines.indexOf("clientes") + 9).split(" ");
                    Eventos.add(new Evento(cadena[0], cadena[1], Integer.parseInt(cadena[2]), clientes.length));
                }
            }
            br.close();
            fr.close();
            return Eventos;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean AgregarCliente(String actividadElegida, String cedula, String nombre) {

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "", lines = "";
            String evento = null;
            while ((line = br.readLine()) != null) {
                String cadena[] = line.split(" ");
                if (cadena[0].equals(actividadElegida)) {
                    evento = line;
                } else {
                    lines = lines + line + "\n";
                }
            }
            br.close();
            fr.close();
            if (evento != null) {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                String eventoConUsuario = evento + " " + cedula + "-" + nombre + "\n";
                pw.print(lines);
                pw.print(eventoConUsuario);
                pw.close();
                bw.close();
                fw.close();
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean RegistrarEvento(Evento evento) {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(evento.getActividad() + " " + evento.getHorario() + " " + evento.getNumeroDeCupos() + " clientes");

            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }
}
