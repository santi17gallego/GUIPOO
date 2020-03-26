package windows.Cliente;

import Excepciones.EstructuraNoValida;
import gestorAplicacion.paquete1.Cliente;
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

public class ConsultarPesoIdeal extends FlowPane {
    
    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;
    public ConsultarPesoIdeal() {
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
        Label nombreProcesolb = new Label("Calcular peso ideal");
        Label descripcionProcesolb = new Label("Simplemente agregando la estatura, !podemos imprimir tu peso ideal!");
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
        informacion = new Label("Digite su estatura");
        campo = new TextField();
        enviarbtn = new Button("Enviar");
        enviarParametrobtn = new Button("Calcular peso ideal");
        resultadota = new TextArea();
        calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, resultadota);
        this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

        enviarbtn.setOnAction(new HandlerEnviarPeso());
    }
    public class HandlerEnviarPeso implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String parametro = campo.getText();
            try {
                String a = new Cliente().pesoIdeal(Float.parseFloat(parametro));
                resultadota.setText(a);
            } catch (EstructuraNoValida ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        }
    }
}
