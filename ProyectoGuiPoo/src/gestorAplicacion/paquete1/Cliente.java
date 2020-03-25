package gestorAplicacion.paquete1;

import BaseDatos.GestorEvento;
import BaseDatos.GestorSugerencia;
import BaseDatos.GestorUsuario;
import Excepciones.EstructuraNoValida;
import gestorAplicacion.paquete2.Evento;
import java.util.ArrayList;


public class Cliente extends Usuario implements Sugerencia{
    
    protected String telefono;
    private float peso;
    private float estatura;
    private int edad;
    private String genero;
    
    //CONSTRUCTORES
    
    public Cliente(){}
    
    public Cliente(String cedula, String nombre, String contrasena, int edad, float peso,float estatura, String genero,String telefono) {
        super(nombre, cedula, contrasena);
        this.telefono = telefono;
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.genero = genero;
    }
    public Cliente(String nombre, String cedula, String contrasena) { 
        super(nombre, cedula, contrasena);
    }
    
    //SETTERS

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    //GETTERS

    public String getTelefono() {
        return telefono;
    }


    public float getPeso() {
        return peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }
    
    public static boolean registrarse(Cliente cliente){
        return GestorUsuario.RegistrarUsuario(cliente);
    }
    
//MÉTODOS CONCRETOS
    public String pesoIdeal(float estatura) throws EstructuraNoValida{
        if(estatura>0){
            float a = (estatura*100)-100;
            return "Su peso ideal es: "+a;
        }else{
            throw new EstructuraNoValida();
        }
       

    }
    
    public String calcularkcaloriasquemadas(int distanciaRecorrida) {

        float kcalquemadas = distanciaRecorrida * this.getPeso();
        int caloriasdiariash = 2200;//hombre en sobrepeso
        int caloriasdiariasm = 2000;//mujer en sobrepeso
        int caloriasdiariash2 = 3500;//hombre en peso normal
        int caloriasdiariasm2 = 3200;//mujer en peso normal
        int caloriasdiariash3 = 4000; //hombre en peso bajo
        int caloriasdiariasm3 = 3800; //mujeres en peso bajo
         int caloriasdiariash4 = 1800; //hombre en peso bajo
        int caloriasdiariasm4 = 1600; //mujeres en peso bajo
        String response=null;
        String estado = new Instructor().estadoActual(this);
        if (estado.equals("Peso bajo") && distanciaRecorrida <= 1 && this.getGenero().equals("f")) {
            response="Las calorias quemadas son suficientes y has quemado " + kcalquemadas + " de " + caloriasdiariasm3 + " que necesitas para estar en un buen estado físico.";
        } else if (estado.equals("Peso bajo") && distanciaRecorrida > 1 && this.getGenero().equals("f")) {
            response="No deberias quemar tantas calorias, ya que has quemado " + kcalquemadas + " de " + caloriasdiariash3 + " que necesitas";
        } else if (estado.equals("Peso normal") && distanciaRecorrida <= 2 && this.getGenero().equals("f")) {
            response="Puedes correr más para aumentar tus calorias quemadas, aunque no sería recomendable, ya que has quemmado " + kcalquemadas + " de " + caloriasdiariasm2 + " que necesitas.";
        } else if (estado.equals("Peso normal") && distanciaRecorrida > 2 && this.getGenero().equals("f")) {
            response="Con estas calorias son suficientes para mantenerte en forma, deberias detenerte, ya que has quemado " + kcalquemadas + " de " + caloriasdiariasm2 + " que necesitas";
        } else if (estado.equals("Sobrepeso") && distanciaRecorrida <= 3 && this.getGenero().equals("f")) {
            response="Necesitas hacer por lo menos 3 veces más de ejercicio, ya que has quemado " + kcalquemadas + " de " + caloriasdiariasm + " que necesitas quemar para estar en forma.";
        } else if (estado.equals("Sobrepeso") && distanciaRecorrida > 3 && this.getGenero().equals("f")) {
            response="Sigue así, ¡No pares!, has quemado" + kcalquemadas + " de " + caloriasdiariasm + " que necesitas quemar para estar en forma.";
        }else if (estado.equals("Obeso") && distanciaRecorrida <= 4 && this.getGenero().equals("f")) {
            response="Necesitas hacer por lo menos 3 veces mas de ejercicio, ya que has quemado " + kcalquemadas + " de " + caloriasdiariasm4 + " que necesitas.";
        } else if (estado.equals("Obeso") && distanciaRecorrida > 4&& this.getGenero().equals("f")) {
            response="Sigue así, ¡No pares!, ya que has quemado " + kcalquemadas + " de " + caloriasdiariasm4 + " que necesitas.";
        }
       else if (estado.equals("Peso bajo") && distanciaRecorrida <= 2 && this.getGenero().equals("m")) {
            response="las calorias quemadas son suficientes, ya que has quemado" + kcalquemadas + "de" + caloriasdiariash3 + "que necesitas";
        } else if (estado.equals("Peso bajo") && distanciaRecorrida > 2 && this.getGenero().equals("m")) {
            response="no deberias quemar tantas calorias, ya que has quemado" + kcalquemadas + "de" + caloriasdiariash3 + "que necesitas";
        } else if (estado.equals("Peso normal") && distanciaRecorrida <= 3 && this.getGenero().equals("m")) {
            response="puedes correr mas para quemar mas calorias, aunque no seria recomendable, ya que has quemado" + kcalquemadas + "de" + caloriasdiariash2 + "que necesitas";
        } else if (estado.equals("Peso normal") && distanciaRecorrida > 3 && this.getGenero().equals("m")) {
            response="con estas calorias son suficientes para mantenerte en forma, deberias detenerte, ya que has quemado" + kcalquemadas + "de" + caloriasdiariash2 + "que necesitas";
        } else if (estado.equals("Sobrepeso") && distanciaRecorrida <= 4 && this.getGenero().equals("m")) {
            response="necesitas hacer mas de ejercicio, ya que has quemado" + kcalquemadas + "de" + caloriasdiariash + "que necesitas";
        } else if (estado.equals("Sobrepeso") && distanciaRecorrida > 5 && this.getGenero().equals("m")) {
            response="sigue asi, dont Stop!, ya que has quemado" + kcalquemadas + "de" + caloriasdiariash + "que necesitas";
        }else if (estado.equals("Obeso") && distanciaRecorrida <= 5 && this.getGenero().equals("m")) {
            response="necesitas hacer mas de ejercicio, ya que has quemado " + kcalquemadas + " de" + caloriasdiariash4 + " que necesitas";
        } else if (estado.equals("Obeso") && distanciaRecorrida > 5 && this.getGenero().equals("m")) {
            response="sigue asi, no pares!, ya has quemado " + kcalquemadas + " de " + caloriasdiariash4 + " que necesitas quemar";
        }
        return response;
    }
    //MÉTODO IMPLEMENTADO DE LA INTERFAZ SUGERENCIA
    @Override
    public boolean comentar(String comentario) {
        return GestorSugerencia.RegistrarSugerencia(comentario);
    }
    
    public ArrayList<Evento> consultarEventos() {
        return GestorEvento.ConsultarEventos();
    }
    
    public boolean agregarCliente(String act, String cedula, String nombre) {
        return GestorEvento.AgregarCliente(act, cedula, nombre);
    }
}
