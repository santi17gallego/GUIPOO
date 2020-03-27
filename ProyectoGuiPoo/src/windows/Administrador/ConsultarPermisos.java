package windows.Administrador;

/*
    * Este modulo se encarga de consultar permisos a los usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */

import gestorAplicacion.paquete1.Administrador;
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
    * Esta clase retorna un Pane con la información de los permisos.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
public class ConsultarPermisos extends FlowPane{
    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;

    public ConsultarPermisos() {

        this.setOrientation(Orientation.VERTICAL);
        this.setAlignment(Pos.CENTER);
        FlowPane eliminarUsuario = new FlowPane();
        eliminarUsuario.setVgap(5);
        eliminarUsuario.setHgap(5);
        this.setVgap(5);
        this.setHgap(5);
        eliminarUsuario.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        eliminarUsuario.setPadding(new Insets(5, 5, 5, 5));
        Label nombreProcesolb = new Label("Eliminar usuario");
        Label descripcionProcesolb = new Label("Con este método el administrador puede eliminar usuarios.");
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
        enviarbtn = new Button("Enviar");
        resultadota = new TextArea();
        resultadota.setWrapText(true);
        eliminarUsuario.getChildren().addAll(campo, enviarbtn, resultadota);
        this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, eliminarUsuario);

        enviarbtn.setOnAction(new HandlerEnviarConsultarDieta());

    }

    
/*
    * Esta clase se encarga de consultar permisos a los usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerEnviarConsultarDieta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Administrador admin = (Administrador) new MenuDeConsola().getSesion();
            String array[]= admin.consultarPermisos(campo.getText());
            String permisos = "";
            for (String string : array) {
                permisos = permisos+string+"\n";
            }
            resultadota.setText(permisos);
        }
    }
}
