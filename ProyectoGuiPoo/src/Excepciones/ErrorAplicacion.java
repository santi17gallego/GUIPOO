
package Excepciones;

public class ErrorAplicacion extends Exception {
    
    String mensajesecundario;
    
    
    public ErrorAplicacion(){
        super("Esta excepción es la más general del sistema por tanto todas las"
                + "excepciones programadas mostrarán esto y proviene de ErrorAplicacion");
    }
    
}
