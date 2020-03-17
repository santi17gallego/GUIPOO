package windows;

import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import uiMain.menuConsola.MenuDeConsola;

/**
 *
 * @author Juan Camilo Hoyos
 */
public class BodyArt extends Application {
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
    
    
    //Login
    
    
    Button ingresarbt;
    TextField usuariotf;
    TextField contraseñatf;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane miborderpane = new BorderPane();
        miborderpane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        primaryStage.setTitle("");

        miborderpane.setPadding(new Insets(10, 10, 10, 10));
        Button salirbtn = new Button("salir");
        Button descripcionbtn = new Button("Descripcion");
        GridPane migridpane = new GridPane();

        migridpane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        migridpane.setPadding(new Insets(5, 5, 5, 5));

        Label nombrelb = new Label("BodyArt");

        migridpane.add(nombrelb, 1, 1);
        migridpane.add(salirbtn, 5, 1);
        migridpane.add(descripcionbtn, 6, 1);
        migridpane.setVgap(3);
        migridpane.setHgap(5);

        miborderpane.setTop(migridpane); //metimos primer grid a mi
        //hasta aca bien

        //MIBORDERPANER
        BorderPane organizador = new BorderPane();
        miborderpane.setCenter(organizador);

        GridPane migridpane2 = new GridPane();  //segundo panel creado izquierdo.
        migridpane2.setPadding(new Insets(10, 10, 10, 10));
        GridPane migridpane3 = new GridPane(); //segundo panel creado derecho.
        migridpane3.setPadding(new Insets(10, 10, 10, 10));
        migridpane3.setMaxWidth(Double.MAX_VALUE);
        organizador.setLeft(migridpane2);
        organizador.setRight(migridpane3);
        organizador.setCenter(null);

        migridpane3.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        migridpane2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        //MIGRIDPANE2
        BorderPane miborderpane2_1 = new BorderPane(); //border de saludo.
        GridPane migridpane2_2 = new GridPane();
        migridpane2.add(miborderpane2_1, 0, 0); //anidamos 
        migridpane2.add(migridpane2_2, 0, 1); //anidamos
        migridpane2.setVgap(5);
        migridpane2.setHgap(5);

        //borderpane2_1
        Label saludobl = new Label("Bienvenidos al gimnasio Body Art");
        miborderpane2_1.setCenter(saludobl);

        miborderpane2_1.setPadding(new Insets(10, 10, 10, 10));

        //Gridpane2_2
        usuariotf = new TextField();
        contraseñatf = new TextField();
        ingresarbt = new Button("Ingresar");
        ingresarbt.setOnAction(new HandlerIngresar());
        Button registrarsebt = new Button("Registrarse");

        migridpane2_2.add(usuariotf, 0, 0);
        migridpane2_2.add(contraseñatf, 1, 0);
        migridpane2_2.add(ingresarbt, 0, 1);
        migridpane2_2.add(registrarsebt, 0, 3);

        migridpane2_2.setHgap(3);
        migridpane2_2.setVgap(3);

        //colocar lineas chimbas
        migridpane2_2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        migridpane2_2.setPadding(new Insets(10, 10, 10, 10));

        //GRIDPANE3
        BorderPane miborderpane3_1 = new BorderPane();
        BorderPane miborderpane3_2 = new BorderPane();

        migridpane3.add(miborderpane3_1, 0, 0);
        migridpane3.add(miborderpane3_2, 0, 1);
        miborderpane3_1.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        miborderpane3_2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        miborderpane3_1.setCenter(new Label("Aqui va una imagen"));
        miborderpane3_1.setPadding(new Insets(10, 10, 10, 10));
        miborderpane3_2.setPadding(new Insets(10, 10, 10, 10));
        //  
        Scene primeraescena = new Scene(miborderpane, 550, 400);
        primaryStage.setScene(primeraescena);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void StageUser(){
        Stage stage= new Stage();
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

        stage.setTitle("Body Art");
        stage.setScene(scene);
        stage.show();
    }
    

    class HandlerIngresar implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String usuario = usuariotf.getText();
            String contrasena = contraseñatf.getText();
            Object array[] = Usuario.iniciarSesion(usuario, contrasena);
            if (array == null) {
                //Acá va ventana emergente
            } else {
                MenuDeConsola.sesion = (Usuario) array[0];
                MenuDeConsola.crearMenu((String[]) array[1]);
                StageUser();
            }
        }

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
