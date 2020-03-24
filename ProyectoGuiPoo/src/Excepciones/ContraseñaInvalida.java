
package Excepciones;


public class ContraseñaInvalida extends ExceptionC1{
    
    public ContraseñaInvalida(){
        super();
        this.mensajeespecifico="Yo trataré los errores cuando ingresan una contraseña en el ingreso,"
                + "y esta contraseña no es válida";
    }
}
