package windows;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import uiMain.menuConsola.MenuDeConsola;

public class UserWindow extends Application {

    BorderPane centro;
    Button archivobtn;
    Button procesosbtn;
    Button ayudabtn;

    //slg
    Button calcularPesoIdealbtn;
    Button enviarbtn;

    Label informacion;

    TextField peso;

    public TextArea resultadoPesoIdeal;

    int pesoEntero;

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
//            Usuario user = MenuDeConsola.sesion;
            Usuario user = new Cliente("1193", "Slg", "1193", 19, 68, 170, "m", "541");
            FieldPanel fieldPanel = null;
            if (user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                String criterios[] = {"Cédula", "Nombre", "Contraseña", "Peso", "Estatura", "Edad", "Genero", "Telefono"};
                String valores[] = {cliente.getCedula(), cliente.getNombre(), cliente.getContrasena(),String.valueOf(cliente.getPeso()), String.valueOf(cliente.getEstatura()), String.valueOf(cliente.getEdad()), cliente.getGenero(), cliente.getTelefono()};
                boolean estado[] = {false, true, true, true, true, true, true, true,};
                fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
            }
            centro.setCenter(fieldPanel.getGrid());
        }
    }

    class HandlerProcesos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            FlowPane opciones = new FlowPane(Orientation.VERTICAL);
            opciones.setVgap(20);
            opciones.setHgap(20);
            calcularPesoIdealbtn = new Button("Calcular peso ideal");
            Button imprimirAlgobtn = new Button("Calcular IMC");
            opciones.getChildren().addAll(imprimirAlgobtn, new Button("TMB"), new Button("Dieta"), calcularPesoIdealbtn);

            calcularPesoIdealbtn.setOnAction(new HandlerCalcularPesoIdeal());
            imprimirAlgobtn.setOnAction(new HandlerImprimirAlgo());

            centro.setCenter(opciones);

            //Slg
        }
    }

    class HandlerAyuda implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Descripcion del mensaje", "Titulo del mensaje", JOptionPane.PLAIN_MESSAGE);
        }
    }

    //Slg
    class HandlerCalcularPesoIdeal implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(20);
            calcularPesoIdeal.setHgap(20);
            informacion = new Label("Digite su estatura");
            peso = new TextField();
            enviarbtn = new Button("Enviar");
            calcularPesoIdealbtn = new Button("Calcular peso ideal");
            resultadoPesoIdeal = new TextArea();
            calcularPesoIdeal.getChildren().addAll(informacion, peso, enviarbtn, resultadoPesoIdeal);

            centro.setCenter(calcularPesoIdeal);

            enviarbtn.setOnAction(new HandlerEnviarPeso());

        }
    }

    class HandlerEnviarPeso implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String pesoDigitado = peso.getText();
            pesoEntero = Integer.parseInt(pesoDigitado);
            String pesoString = String.valueOf((pesoEntero) - 100);
            resultadoPesoIdeal.appendText(pesoString);
        }
    }

    class HandlerImprimirAlgo implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            FlowPane imprimirAlgo = new FlowPane();
            imprimirAlgo.setVgap(20);
            imprimirAlgo.setHgap(20);
            informacion = new Label("Digite su estatura");
            peso = new TextField();
            enviarbtn = new Button("Enviar");
            calcularPesoIdealbtn = new Button("Calcular peso ideal");
            resultadoPesoIdeal = new TextArea();
            imprimirAlgo.getChildren().addAll(informacion, peso, enviarbtn, resultadoPesoIdeal);

            centro.setCenter(imprimirAlgo);

            enviarbtn.setOnAction(new HandlerEnviarAlgo());
        }

    }

    class HandlerEnviarAlgo implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Instructor slg = new Instructor();
            resultadoPesoIdeal.appendText(slg.imprimiendoAlgo());
        }
    }
}
