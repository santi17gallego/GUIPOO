package uiMain.menuConsola;

public abstract class OpcionDeMenu {
    private String nombre;
    abstract public void ejecutar();
    
    public OpcionDeMenu(){}
    
    public OpcionDeMenu(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
}
