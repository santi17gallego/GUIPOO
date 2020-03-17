package gestorAplicacion.paquete1;
//La interfaz sugerencia se crea porque todos los usuarios del sistema de alguna forma son consumidores
//entonces, aparte de ser usuarios son consumidores y pueden opinar acerca del funcionamiento del sistema
public interface Sugerencia {
    
    public abstract boolean comentar(String comentario);//Método abstracto que obliga a las clases que lo implementen
    //definirlo en su cuerpo, de esto trata el polimorfismos
}
