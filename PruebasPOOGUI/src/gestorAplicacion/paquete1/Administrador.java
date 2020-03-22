package gestorAplicacion.paquete1;

import BaseDatos.GestorPermiso;
import BaseDatos.GestorUsuario;

public class Administrador extends Usuario {//la clase administrador se crea por la necesidad de
    //incluir a los administradores en el sistema de usuarios, sobretodo para el inicio de sesión

    //CONSTRUCTOR DE CLASE
    public Administrador(String nombre, String cedula, String contrasena) {
        super(nombre, cedula, contrasena);
    }
    
    public boolean agregarPermisos(String cedula, String arrayPermisos[]){
        return GestorPermiso.AgregarPermisos(cedula, arrayPermisos);
    }
    
    public String[] consultarPermisos(String cedula){
        return GestorUsuario.ConsultarPermisos(cedula);
    }
    
    public String consultarPermisos(){
        return GestorUsuario.ConsultarPermisos();
    }
    
    public boolean eliminarPermisos(String cedula, String arrayPermisos[]){
        return GestorPermiso.EliminarPermisos(cedula, arrayPermisos);
    }
    
    public boolean eliminarUsuario(String cedula){
        return GestorUsuario.EliminarUsuario(cedula);
    }
    
    public boolean registrarUsuario(Usuario user){
        return GestorUsuario.RegistrarUsuario(user);
    }
    
    public String[] consultarPermisosPorTipo(String cedula){
        return GestorPermiso.ConsultarPermisosPorTipo(cedula);
    }
}
