package uiMain.Opciones.Administrador;

import gestorAplicacion.paquete1.Administrador;
import static uiMain.menuConsola.MenuDeConsola.sesion;
import uiMain.menuConsola.OpcionDeMenu;

public class OpcionConsultarTodosLosPermisos extends OpcionDeMenu {
    public OpcionConsultarTodosLosPermisos() {
        super("Consultar todas las opciones de menú.");
    }
    @Override
    public void ejecutar() {
        System.out.println("\nPermisos:\n"+((Administrador)sesion).consultarPermisos());
    }
    
}
