
package windows.Cliente;
/*
    * Este modulo se encarga de consultar las calorias quemadas por un cliente.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
import gestorAplicacion.paquete1.Cliente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
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
    * Esta clase retorna un Pane con la información para consultar las calorias quemadas.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
public class ConsultarCaloriasQuemadas extends FlowPane{
    
    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;

    public ConsultarCaloriasQuemadas() {
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
            Label nombreProcesolb = new Label("Calcular kcalorias quemadas");
            Label descripcionProcesolb = new Label("Al ingresar cierta cantidad de kilometros recorridos y dependiendo de ciertos factores externos\n"
                    + "como peso, genero y entre otros, te decimos las kilo calorias quemadas por sesión.");
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
            informacion = new Label("Digite distancia recorrida");
            campo = new TextField();
            enviarbtn = new Button("Enviar");
            resultadota = new TextArea();
            resultadota.setWrapText(true);
            calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, resultadota);
            this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            
          enviarbtn.setOnAction(new HandlerEnviarDistancia());
    }
    
    /*
    * Esta clase se encarga de consultar las calorias quemadas por el cliente.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
      class HandlerEnviarDistancia implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) new MenuDeConsola().getSesion();
            String parametro = campo.getText();
            resultadota.setText(cliente.calcularkcaloriasquemadas(Integer.parseInt(parametro)));
        }
}
     
}
 