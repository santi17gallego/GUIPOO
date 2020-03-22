package gestorAplicacion.paquete2;

import gestorAplicacion.paquete1.*;
public class Rutina {
    private Cliente cliente;
    private String tipoDieta;
    private String descripcion;
    private Instructor instructor;
    
//CONSTRUCTOR

    public Rutina(Cliente cliente, String tipoDieta, String descripcion, Instructor instructor) {
        this.cliente = cliente;
        this.tipoDieta = tipoDieta;
        this.descripcion = descripcion;
        this.instructor = instructor;
    }

//GETTERS

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoDieta() {
        return tipoDieta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Instructor getInstructor() {
        return instructor;
    }
//SETTERS

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTipoDieta(String tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
}
