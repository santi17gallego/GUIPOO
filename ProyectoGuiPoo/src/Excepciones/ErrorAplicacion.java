
package Excepciones;

public class ErrorAplicacion extends Exception {
    
    
    
    
    public ErrorAplicacion(String Mensaje){
        
//        super("Esta excepción es la más general del sistema por tanto todas las"
//                + "excepciones programadas mostrarán esto y proviene de ErrorAplicacion");
        super("Manejo de errores de la Aplicación: "+Mensaje);
    }
    
}
