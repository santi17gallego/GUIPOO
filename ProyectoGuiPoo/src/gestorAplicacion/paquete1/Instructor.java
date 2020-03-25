package gestorAplicacion.paquete1;

import BaseDatos.GestorSugerencia;
import BaseDatos.GestorUsuario;
import Excepciones.UsuarioInvalido;

//slg

public class Instructor extends Usuario implements Sugerencia{
    
//ATRIBUTOS DE CLASES
    final double paraTmbF = 655.0;
    final double paraTmbM = 66;
    
//CONSTRUCTORES
    public Instructor(String nombre, String cedula, String contrasena) {
        super(nombre, cedula, contrasena);
    }

    public Instructor() {
    }
    
 //METODOS CONCRETOS
    public float calcularImc(Cliente cliente) {
        float imc = cliente.getPeso() / (cliente.getEstatura() * cliente.getEstatura());
        return imc;
    }

    public String calcularRutina(Cliente cliente) {
        String descripcion = null;
        String estadoActual = this.estadoActual(cliente);
        if (estadoActual.equals("Peso bajo")) {
            descripcion = "El objetivo será ganar masa muscular\nEjercicios:\n-Press banca\n-Peso muerto\n-Press militar"
                    + "\n-Sentadilla\n-Remo Horizontal\n-Press de hombro\n Duración de entrenamiento:\nEntre 45 y 90 minutos\nDescanso:\nEntre 60 y 120 segundos\nIntensidad\n3 días a la semana";
        } else if (estadoActual.equals("Peso normal")) {
            descripcion = "El objetivo será ganar masa muscular y tonificar el cuerpo\nEjercicios:\n-Abdominales\n-Peso muerto\n-Press militar"
                    + "\n-Sentadilla\n-Cardio\n-Press de hombro\n Duración de entrenamiento:\nEntre 60 y 120 minutos\nDescanso:\nEntre 45 y 60 segundos\nIntensidad\n5 días a la semana\nRecomendacion:\nTrabajar con poco peso y muchas repeticones de lo usual";
        } else if (estadoActual.equals("Sobrepeso")) {
            descripcion = "El objetivo será bajar de peso\nEjercicios:\n-Ciclismo\n-Natación\n-Atletismo"
                    + "\n-Rotación de tronco\n-Crossfit\n-Barras\n Duración de entrenamiento:\nEntre 60 y 120 minutos\nDescanso:\nEntre 40 y 50 segundos\nIntensidad\n5 días a la semana\nRecomendacion:\nRealizar entre descanso, 30 segundos de cinta o elíptica";
        } else {
            descripcion = "El objetivo será bajar de peso e inciar hábitos de vida saludable\nEjercicios:\n-Ciclismo\n-Natación\n-Atletismo"
                    + "\n-Abdominales\n-Cardio\n-Lazos\n Duración de entrenamiento:\nEntre 45 y 60 minutos\nDescanso:\nEntre 60 y 120 segundos\nIntensidad\n7 días a la semana\nRecomendacion:\nSolicitar asesoría con el instructor";
        }
        return descripcion;

    }

    public float calcularTmb(Cliente cliente) {
        float tmb = 0;
        if (cliente.getGenero().equals("f")) {
            tmb = (float) (paraTmbF + (9.6 * cliente.getPeso()) + (1.8 * cliente.getEstatura()) - (4.7 * cliente.getEdad()));
        } else {
            tmb = (float) (paraTmbM + (13.7 * cliente.getPeso()) + (5.0 * cliente.getEstatura()) - (6.75 * cliente.getEdad()));
        }
        return tmb;

    }

    public String calcularDieta(Cliente cliente, String cantidadEjercicio) {
        //"Ingrese cantidad de ejercicio (si es poco: 2 o menos días (digite 1)\nSi es ligero: 3 días (digite 2)\nSi es moderado: 3-5 días (digite 3)\nSi es deportista: 6-7 días (digite 4)\nSi es atleta: 7 días mañana y tarde (digite 5)");

        float tmb = calcularTmb(cliente);
        float calorias;
        if (cantidadEjercicio.equals("1")) {
            calorias = (float) (tmb * 1.2);
        } else if (cantidadEjercicio.equals("2")) {
            calorias = (float) (tmb * 1.375);
        } else if (cantidadEjercicio.equals("3")) {
            calorias = (float) (tmb * 1.55);
        } else if (cantidadEjercicio.equals("4")) {
            calorias = (float) (tmb * 1.72);
        } else {
            calorias = (float) (tmb * 1.9);
        }
        return "Diariamente consumes " + calorias + ". Por lo tanto, si quieres bajar de peso debes consumir menos de las indicadas, de lo contrario consume más.\nPara bajar de peso recomendamos"
                + " reducir el consumo de carbohidratos, azúcares, grasas trans, carnes magras y subir la ingesta de frutas, verduras, pescado y pollo.\n"
                + "Para subir de peso aumente el número de comidas diarias entre 5 y 6, incluyendo mayor cantidad de carbohidratos, proteinas acompañado de uno"
                + " de nuestros suplementos alimenticios de la marca BodyArt.";
    }

    public String estadoActual(Cliente cliente) {
        String estado;
        float imc = this.calcularImc(cliente);
        if (imc <= 18.5) {
            estado = "Peso bajo";

        } else if (imc > 18.5 && imc <= 24.9) {
            estado = "Peso normal";
        } else if (imc > 25 && imc <= 29.9) {
            estado = "Sobrepeso";
        } else {
            estado = "Obeso";
        }
        return estado;
    }

    @Override
    public boolean comentar(String comentario) {
        return GestorSugerencia.RegistrarSugerencia(comentario);
    }

    public Cliente consultarCliente(String cedula) throws UsuarioInvalido{
        Cliente cliente = GestorUsuario.ConsultarCliente(cedula);
        if(cliente==null){
            throw new UsuarioInvalido();
        }
        return cliente;
    }
    
    //slg
    public String imprimiendoAlgo() {
        String hola = "Bitches";
        return hola;
    }

}
