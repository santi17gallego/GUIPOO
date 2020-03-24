
package Excepciones;


public class UsuarioInvalido extends ExceptionC2{
    
    public UsuarioInvalido(){
        super();
        this.mensajeespecifico="Yo trataré las excepciones que se presentan cuando ingreso una cedula"
                + "a un método, y esta corresponde a otro usuario: por ejemplo cuando le mando"
                + "una cédula de un instrcutor y necesito la de un cliente";
        
    }
}
