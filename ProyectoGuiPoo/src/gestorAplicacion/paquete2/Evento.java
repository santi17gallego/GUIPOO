package gestorAplicacion.paquete2;

public class Evento {
    private String actividad;
    private String horario;
    private int numeroDeCupos;
    private int inscritos;
    
//CONSTRUCTOR
    public Evento(String actividad, String horario, int numeroDeCupos, int inscritos) {
        this.actividad = actividad;
        this.horario = horario;
        this.numeroDeCupos = numeroDeCupos;
        this.inscritos = inscritos;
    } 
    public Evento(String actividad, String horario, int numeroDeCupos) {
        this.actividad = actividad;
        this.horario = horario;
        this.numeroDeCupos = numeroDeCupos;
    } 
    
//GETTERS
    public int getInscritos() {
        return inscritos;
    }
    public String getActividad() {
        return actividad;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    public String getHorario() {
        return horario;
    }

    public int getNumeroDeCupos() {
        return numeroDeCupos;
    }
//SETTERS
    
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    

    public void setHorario(String horario) {
        this.horario = horario;
    }
  
     public void setNumeroDeCupos(int numeroDeCupos) {
        this.numeroDeCupos = numeroDeCupos;
    }
      
}