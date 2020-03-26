package gestorAplicacion.paquete1;

import BaseDatos.GestorUsuario;
import Excepciones.CedulaOContrasenaInvalida;

public abstract class Usuario {
    private String nombre;
    private String cedula;
    private String contrasena;
    
//CONSTRUCTORES
    public Usuario(){
    }
    
    
    public Usuario(String nombre, String cedula, String contrasena){
        this.cedula=cedula;
        this.nombre=nombre;
        this.contrasena=contrasena;
    }
    
    public Usuario(String cedula, String contrasena){
        this.cedula=cedula;
        this.contrasena=contrasena;
    }
    
//GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public static Object[] iniciarSesion(String cedula, String contrasena) throws CedulaOContrasenaInvalida{
        return GestorUsuario.IniciarSesion(cedula, contrasena);
    }
    
    public static boolean ModificarUsuario(Usuario usuario){
        return GestorUsuario.ModificarUsuario(usuario);
    }
}
