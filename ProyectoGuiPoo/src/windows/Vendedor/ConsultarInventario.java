
package windows.Vendedor;

import Excepciones.EstructuraNoValida;
import Excepciones.UsuarioInvalido;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Suplemento;
import java.util.ArrayList;
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

public class ConsultarInventario extends FlowPane {
    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;
  
   
   public ConsultarInventario() {
       
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
            Label nombreProcesolb = new Label("Consultar inventario");
            Label descripcionProcesolb = new Label("Al usar este proceso, este no necesita ningun parámetro y automáticamente\n"
                    + "hace un listado de los productos que se encuentran en nuestro gimnasio BodyArt.");
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
            enviarbtn = new Button("Consultar inventario");
            resultadota = new TextArea();
            calcularPesoIdeal.getChildren().addAll(enviarbtn, resultadota);
            this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            

            enviarbtn.setOnAction(new HandlerEnviarConsultarInventario());

    }
     class HandlerEnviarConsultarInventario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Vendedor vendedor = (Vendedor) new MenuDeConsola().getSesion();
            ArrayList<Suplemento> a = vendedor.consultarInventario();
            String inventario = "Nombre Precio Descripción\n";
            for (Suplemento suplemento : a) {
                inventario = inventario + suplemento.getNombre() + " " + suplemento.getPrecio() + " " + suplemento.getDescripcion() + "\n";
            }
            resultadota.setText(inventario);
        }
    }
}

    

