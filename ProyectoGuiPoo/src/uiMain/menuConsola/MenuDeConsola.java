package uiMain.menuConsola;

import gestorAplicacion.paquete1.Usuario;
import java.util.ArrayList;

public class MenuDeConsola {

    private static ArrayList<String> listaMenu = new ArrayList<String>();

    private static Usuario sesion;

    public ArrayList<String> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(ArrayList<String> listaMenu) {
        MenuDeConsola.listaMenu = listaMenu;
    }

    public Usuario getSesion() {
        return sesion;
    }

    public void setSesion(Usuario sesion) {
        MenuDeConsola.sesion = sesion;
    }

    public void cerrarSesion() {
        listaMenu = new ArrayList<String>();
        sesion = null;
    }

    public static void crearMenu(String lista[]) {
        for (String item : lista) {
            listaMenu.add(item);
        }
    }
}
