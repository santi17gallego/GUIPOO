
package windows.Instructor;
/*
    * Este modulo se encarga de realizar una dieta para un cliente.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
import Excepciones.UsuarioInvalido;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import uiMain.menuConsola.MenuDeConsola;


/*
    * Esta clase retorna un Pane con la información utilizada para consultar una dieta.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
public class ConsultarDieta extends FlowPane {
    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;
   private TextField campo2;
    public ConsultarDieta() {
        
       this.setOrientation(Orientation.VERTICAL);
            this.setAlignment(Pos.CENTER);
            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(5);
            calcularPesoIdeal.setHgap(5);
            this.setVgap(5);
            this.setHgap(5);
            calcularPesoIdeal.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            calcularPesoIdeal.setPadding(new Insets(5, 5, 5, 5));
            Label nombreProcesolb = new Label("Consultar dieta");
            Label descripcionProcesolb = new Label("Al proporcionar la cédula del cliente, generaremos una rutina adecuada\n"
                    + "para nuestro cliente seleccionado.\n"
                    + "Además cada rutina es única y especial para cada uno. ");
            nombreProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            nombreProcesolb.setPadding(new Insets(5, 5, 5, 5));
            descripcionProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            descripcionProcesolb.setPadding(new Insets(5, 5, 5, 5));
            nombreProcesolb.setMaxWidth(Double.MAX_VALUE);
            descripcionProcesolb.setMaxWidth(Double.MAX_VALUE);
            this.setLayoutX(Double.MAX_VALUE);
            this.setLayoutY(Double.MAX_VALUE);
            nombreProcesolb.setAlignment(Pos.CENTER);
            descripcionProcesolb.setAlignment(Pos.CENTER);
            campo = new TextField();
            campo.setPromptText("Cédula del cliente");
            campo2 = new TextField();
            campo2.setPromptText("Cantidad de ejercicio");
            enviarbtn = new Button("Enviar");
            resultadota = new TextArea();
            resultadota.setWrapText(true);
            resultadota.setText("Ingrese cantidad de ejercicio (si es poco: 2 o menos días (digite 1)\n"
                    + "Si es ligero: 3 días (digite 2)\n"
                    + "Si es moderado: 3-5 días (digite 3)\n"
                    + "Si es deportista: 6-7 días (digite 4)\n"
                    + "Si es atleta: 7 días mañana y tarde (digite 5)");
            calcularPesoIdeal.getChildren().addAll(campo, campo2, enviarbtn, resultadota);
            this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

           

            enviarbtn.setOnAction(new HandlerEnviarConsultarDieta());
        
    }
    
    /*
    * Esta clase se encarga de realizar una dieta para un cliente.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerEnviarConsultarDieta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Instructor instructor = (Instructor) new MenuDeConsola().getSesion();
            String parametro = campo.getText();
            String parametro2 = campo2.getText();
            try {
                Cliente cliente = instructor.consultarCliente(parametro);
                resultadota.setText(instructor.calcularDieta(cliente, parametro2));
            } catch (UsuarioInvalido ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        }
    }
    
    
}
