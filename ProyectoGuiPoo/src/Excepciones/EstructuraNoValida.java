
package Excepciones;


public class EstructuraNoValida extends ExceptionC2{
    
    public EstructuraNoValida(){
        super();
        this.mensajeespecifico="Yo trataré las excepciones que se presentan cuando se ingresa"
                + "un valor con coma, y no con puntos, por ejemplo:"
                + "la altura es en metros y separadas por puntos, y quizás "
                + "se ingresa una coma";
        
    }
    
    
}
