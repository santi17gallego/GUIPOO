package windows.Administrador;
/*
    * Este modulo se encarga de agregar permisos a los usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
import gestorAplicacion.paquete1.Administrador;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import uiMain.menuConsola.MenuDeConsola;

/*
    * Esta clase retorna un Pane con la información de los permisos.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
public class AgregarPermisos extends FlowPane {
    
    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button btnguardar =new Button("Guardar");
    private VBox vbox;
    private ArrayList<CheckBox> arrayCheck;
    private Administrador admin = (Administrador) new MenuDeConsola().getSesion();

    public AgregarPermisos() {
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
        Label nombreProcesolb = new Label("Agregar permisos");
        Label descripcionProcesolb = new Label("Opción para agregar permisos a determinado usuario.");
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
        informacion = new Label("Digite la cédula de usuario");
        campo = new TextField();
        enviarbtn = new Button("Enviar");
        vbox = new VBox();
        calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, vbox);
        this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

        enviarbtn.setOnAction(new HandlerConsultarPermisos());

        btnguardar.setOnAction((event) -> {
            String permisos = "";
            for (CheckBox checkBox : arrayCheck) {
                if (checkBox.isSelected()) {
                    permisos = permisos + checkBox.getText() + "#";
                }
            }
            String permisosUp[] = permisos.split("#");
            if (admin.agregarPermisos(campo.getText(), permisosUp)) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setContentText("Acción exitosa.");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Error al agregar permiso.");
                alerta.show();
            }
        });

    }
/*
    * Esta clase se encarga de agregar permisos a los usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    public class HandlerConsultarPermisos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            vbox.getChildren().clear();
            arrayCheck = new ArrayList<CheckBox>();

            String permisosPorTipo[] = admin.consultarPermisosPorTipo(campo.getText());
            for (String string : permisosPorTipo) {
                CheckBox check = new CheckBox(string);
                check.setPadding(new Insets(10));
                vbox.getChildren().add(check);
                arrayCheck.add(check);
            }
            vbox.getChildren().add(btnguardar);
        }
    }
}
