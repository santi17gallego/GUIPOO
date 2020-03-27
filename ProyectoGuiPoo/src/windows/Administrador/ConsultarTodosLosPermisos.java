package windows.Administrador;

/*
    * Este modulo se encarga de consultar todos los permisos de los usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
import gestorAplicacion.paquete1.Administrador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class ConsultarTodosLosPermisos extends FlowPane {

    private Button enviarbtn;
    private TextArea resultadota;

    public ConsultarTodosLosPermisos() {
        this.setOrientation(Orientation.VERTICAL);
        this.setAlignment(Pos.CENTER);
        FlowPane todosLosPermisos = new FlowPane();
        todosLosPermisos.setVgap(5);
        todosLosPermisos.setHgap(5);
        this.setVgap(5);
        this.setHgap(5);
        todosLosPermisos.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        todosLosPermisos.setPadding(new Insets(5, 5, 5, 5));
        Label nombreProcesolb = new Label("Consultar todos los permisos");
        Label descripcionProcesolb = new Label("Se mostrarán todos los permisos que el sistema tiene disponible.");
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
        enviarbtn = new Button("Enviar");
        resultadota = new TextArea();
        resultadota.setWrapText(true);
        todosLosPermisos.getChildren().addAll(enviarbtn, resultadota);
        this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, todosLosPermisos);

        enviarbtn.setOnAction(new HandlerConsultarTodosLosPermisos());
    }
/*
    * Esta clase se encarga de retornar todos los permisos de los usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    public class HandlerConsultarTodosLosPermisos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Administrador admin = (Administrador) new MenuDeConsola().getSesion();
            String permisos = admin.consultarPermisos();
            
            resultadota.setText(permisos);
        }
    }
}
