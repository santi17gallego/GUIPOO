package windows;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UserWindow extends Application {

    BorderPane centro;
    Button archivobtn;
    Button procesosbtn;
    Button ayudabtn;

    @Override
    public void start(Stage userStage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Label userlb = new Label("Usuario: Jaime Guzmán");
        Button salirbtn = new Button("Salir");

        BorderPane root3 = new BorderPane();
        root3.setLeft(userlb);
        root3.setRight(salirbtn);
        root3.setPadding(new Insets(5, 5, 5, 5));
        root.setTop(root3);

        centro = new BorderPane();

        GridPane root2 = new GridPane();
        archivobtn = new Button("Archivo");
        archivobtn.setOnAction(new HandlerArchivo());
        procesosbtn = new Button("Procesos y consultas");
        procesosbtn.setOnAction(new HandlerProcesos());
        ayudabtn = new Button("Ayuda");
        ayudabtn.setOnAction(new HandlerAyuda());
        root2.add(archivobtn, 0, 0);
        root2.add(procesosbtn, 1, 0);
        root2.add(ayudabtn, 2, 0);

        root2.setPadding(new Insets(5, 5, 5, 5));
        root2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        centro.setTop(root2);
        centro.setPadding(new Insets(5, 5, 5, 5));
        centro.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        GridPane form = new GridPane();
        form.add(new Label("Nombre: "), 0, 0);
        form.add(new TextField(), 1, 0);
        form.add(new Label("Cedula: "), 0, 1);
        form.add(new TextField(), 1, 1);
        form.add(new Label("Telefono: "), 0, 2);
        form.add(new TextField(), 1, 2);
        form.setPadding(new Insets(20, 20, 20, 20));
        form.setHgap(10);
        form.setVgap(10);
        centro.setCenter(form);
        root.setCenter(centro);
        Scene scene = new Scene(root, 600, 400);

        userStage.setTitle("Body Art");
        userStage.setScene(scene);
        userStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class HandlerArchivo implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            centro.setCenter(new Label("kjashdfkjsdkfjaskdjfhaksjdhfkasjhdf"));
        }
    }

    class HandlerProcesos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            FlowPane opciones = new FlowPane(Orientation.VERTICAL);
            opciones.setVgap(20);
            opciones.setHgap(20);
            opciones.getChildren().addAll(new Button("Calcular Peso Ideal"), new Button("IMC"), new Button("TMB"), new Button("Dieta"));
            centro.setCenter(opciones);
        }
    }

    class HandlerAyuda implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Descripcion del mensaje", "Titulo del mensaje", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
