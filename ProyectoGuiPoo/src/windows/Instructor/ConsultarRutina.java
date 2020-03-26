
package windows.Instructor;

import Excepciones.EstructuraNoValida;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import uiMain.menuConsola.MenuDeConsola;
import windows.BodyArt;

public class ConsultarRutina extends FlowPane {
     private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;
    public ConsultarRutina() {
        
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
            Label nombreProcesolb = new Label("Calcular rutina");
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
            informacion = new Label("Digite la cédula del cliente");
            campo = new TextField();
            enviarbtn = new Button("Enviar");
            resultadota = new TextArea();
            calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, resultadota);
            this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

           

            enviarbtn.setOnAction(new HandlerEnviarConsultarRutina());
        
        
    }
   
      class HandlerEnviarConsultarRutina implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Instructor instructor = (Instructor) new MenuDeConsola().getSesion();
            String parametro = campo.getText();
            try {
                Cliente cliente = instructor.consultarCliente(parametro);
                resultadota.setText(instructor.calcularRutina(cliente));
            } catch (UsuarioInvalido ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
      
    
    
    
}
    }
}
