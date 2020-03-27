/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows.Administrador;

import Excepciones.UsuarioInvalido;
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

/**
 *
 * @author santi
 */
public class EliminarUsuario extends FlowPane {

    private Label informacion;
    private TextField campo;
    private Button enviarbtn;
    private Button enviarParametrobtn;
    private TextArea resultadota;

    public EliminarUsuario() {

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
        eliminarUsuario.getChildren().addAll(campo, enviarbtn, resultadota);
        this.getChildren().addAll(nombreProcesolb, descripcionProcesolb, eliminarUsuario);

        enviarbtn.setOnAction(new HandlerEnviarConsultarDieta());

    }

    class HandlerEnviarConsultarDieta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Administrador admin = (Administrador) new MenuDeConsola().getSesion();
            if (admin.eliminarUsuario(campo.getText())) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setContentText("Usuario eliminado.");
                alerta.show();
                resultadota.setText("Usuario eliminado de la base de datos.");
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Error al registrar usuario.");
                alerta.show();
            }
        }
    }
}
