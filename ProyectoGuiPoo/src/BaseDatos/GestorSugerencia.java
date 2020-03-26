package BaseDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorSugerencia {

    private static File file = new File("C:\\GUIPOO\\ProyectoGuiPoo\\src\\BaseDatos\\temp\\sugerencias.txt");
    private static BufferedWriter bw = null;
    private static FileWriter fw = null;
    private static PrintWriter pw = null;
    
    public static boolean RegistrarSugerencia(String comentario){
    
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(comentario);
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }
    
}
