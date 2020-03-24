
package Excepciones;


public class CedulaNoExiste extends ExceptionC1{
    
    public CedulaNoExiste(){
        super();
        this.mensajeespecifico="Yo trataré los errores cuando ingresan una cedula en el ingreso,"
                + "y esta cedula no está dentro de los usuarios registrados";
    }
}
