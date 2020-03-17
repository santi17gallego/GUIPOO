package BaseDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class GestorPermiso {

    private static File file = new File("C:\\ProyectoPOO\\ProyectoPOO\\src\\BaseDatos\\temp\\usuarios.txt");
    private static File file2 = new File("C:\\ProyectoPOO\\ProyectoPOO\\src\\BaseDatos\\temp\\permisos.txt");
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static FileReader fr = null;
    private static FileWriter fw = null;
    private static PrintWriter pw = null;

    public static boolean AgregarPermisos(String cedula, String permisos[]) {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "", lines = "";
            String usuario = null;
            while ((line = br.readLine()) != null) {
                String cadena[] = line.split(" ");
                if (cadena[1].equals(cedula)) {
                    usuario = line;
                } else {
                    lines = lines + line + "\n";
                }
            }
            br.close();
            fr.close();
            if (usuario != null) {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                String usuarioConPermisos = usuario.substring(0, usuario.indexOf("permisos") + 8) + CompararAgregarPermisos(usuario.substring(usuario.indexOf("permisos") + 8), permisos);
                pw.print(lines);
                pw.println(usuarioConPermisos);
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

    public static String CompararAgregarPermisos(String old, String nueva[]) {
        String cadena[] = old.trim().split(" ");
        for (String itemN : nueva) {
            boolean exist = true;
            for (String itemO : cadena) {
                if (itemN.equals(itemO)) {
                    exist = false;
                }
            }
            if (exist) {
                old = old + " " + itemN;
            }
        }
        return old;
    }

    public static boolean EliminarPermisos(String cedula, String permisos[]) {
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "", lines = "";
            String usuario = null;
            while ((line = br.readLine()) != null) {
                String cadena[] = line.split(" ");
                if (cadena[1].equals(cedula)) {
                    usuario = line;
                } else {
                    lines = lines + line + "\n";
                }
            }
            br.close();
            fr.close();
            if (usuario != null) {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                String usuarioConPermisos = usuario.substring(0, usuario.indexOf("permisos") + 8) + CompararEliminarPermisos(usuario.substring(usuario.indexOf("permisos") + 8), permisos);
                pw.print(lines);
                pw.println(usuarioConPermisos);
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

    public static String CompararEliminarPermisos(String old, String nueva[]) {
        String cadena[] = old.trim().split(" ");
        old = "";
        for (String itemO : cadena) {
            boolean exist = true;
            for (String itemN : nueva) {
                if (itemN.equals(itemO)) {
                    exist = false;
                }
            }
            if (exist) {
                old = old + " " + itemO;
            }
        }
        return old;
    }

    public static String[] ConsultarPermisosPorTipo(String cedula) {
        String tipo=ConsultarTipoDeUsuario(cedula);
        if (tipo == null) {
            return null;
        } else {
            String permisos[] = null;
            try {
                fr = new FileReader(file2);
                br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    String cadena[] = line.split(" ");
                    if (cadena[0].equals(tipo)) {
                        permisos = Arrays.copyOfRange(cadena, 1, cadena.length);
                        break;
                    }
                }
                br.close();
                fr.close();
                return permisos;
            } catch (Exception ex) {
                return null;
            }
        }
    }

    public static String ConsultarTipoDeUsuario(String cedula) {
        try {
            String tipo=null;
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String cadena[] = line.split(" ");
                if (cadena[1].equals(cedula)) {
                    tipo = cadena[0];
                    break;
                }
            }
            br.close();
            fr.close();
            return tipo;
        } catch (Exception ex) {
            return null;
        }
    }
}
