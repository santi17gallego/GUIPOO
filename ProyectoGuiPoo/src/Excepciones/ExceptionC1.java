
package Excepciones;

public class ExceptionC1 extends ErrorAplicacion {
    
    String mensajeespecifico;
    public ExceptionC1(){
        super();
        this.mensajesecundario="Este mensaje es solo para las expeciones hijas de C1";
    }
}
