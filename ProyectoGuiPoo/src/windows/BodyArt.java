package windows;

import gestorAplicacion.paquete1.Administrador;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import uiMain.menuConsola.MenuDeConsola;

public class BodyArt extends Application {

    private BorderPane centro;
    private Button archivobtn;
    private Button procesosbtn;
    private Button ayudabtn;
    private Button salirbtn = new Button("Salir");
    //slg
    private Button calcularPesoIdealbtn;
    private Button enviarbtn;

    Button registrarsebtn = new Button("Registrarse");
    Label informacion;

    TextField peso;
    BorderPane miborderpane = new BorderPane();
    BorderPane miborderpane3_1 = new BorderPane();
    public TextArea resultadoPesoIdeal;
    BorderPane miborderpane3_2 = new BorderPane();
    int pesoEntero;

    //Login
    private Button ingresarbtn = new Button("Ingresar");
    TextField usuariotf;
    TextField contraseñatf;
    Button descripcionbtn = new Button("Descripcion");
    static int con = 1, con2 = 7;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Body Art");
        Scene primeraescena = escenaInicial();

        primaryStage.setScene(primeraescena);
        primaryStage.show();

        ingresarbtn.setOnAction((event) -> {
            String usuario = usuariotf.getText();
            String contrasena = contraseñatf.getText();
            Object array[] = Usuario.iniciarSesion(usuario, contrasena);
            if (array == null) {
                new Alert(Alert.AlertType.ERROR, "Error al realizar la acción").show();
            } else {
                new MenuDeConsola().setSesion((Usuario) array[0]);
                MenuDeConsola.crearMenu((String[]) array[1]);
                primaryStage.setScene(escenaUsuario());
            }
        });

        registrarsebtn.setOnAction((event) -> {
            String criterios[] = {"Cédula", "Nombre", "Contraseña", "Peso", "Estatura", "Edad", "Genero", "Telefono"};
            String valores[] = null;
            boolean estado[] = null;
            FieldPanel fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
//                form.setPadding(new Insets(20, 20, 20, 20));
//                form.setHgap(10);
//                form.setVgap(10);

            GridPane migrid = fieldPanel.getGrid();
            migrid.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            migrid.setPadding(new Insets(10, 10, 10, 10));
            miborderpane.setCenter(migrid);
            //Button atrasbtn = new Button("Atrás");
        });

        salirbtn.setOnAction((event) -> {
            //primaryStage.setScene(escenaInicial());
            primaryStage.close();
        });

        miborderpane3_1.setOnMouseEntered((event) -> {
            if (con == 5) {
                con = 1;
            }
            Image img = new Image("imagenes/" + con + ".jpg");
            ImageView imgv = new ImageView(img);
            imgv.setFitWidth(200);
            imgv.setFitHeight(200);
            miborderpane3_1.setCenter(imgv);
            con++;
        });

        miborderpane3_2.setOnMouseClicked((event) -> {
            if (con2 == 10) {
                con2 = 6;
            }
            Image img = new Image("imagenes/" + con2 + ".jpg");
            ImageView imgv = new ImageView(img);
            imgv.setFitWidth(90);
            imgv.setFitHeight(90);
//            HBox hbx = new HBox();
//            hbx.getChildren().add(imgv);
//            StackPane stp = new StackPane();
//            stp.getChildren().addAll(new Label("Nombre: "), new Label("Edad: "), new Label("Genero: "));
//            hbx.getChildren().add(stp);
            miborderpane3_2.setTop(imgv);
            Label lb = new Label();
            lb.setMaxWidth(200);
            lb.setTextFill(Color.web("WHITE"));
            if (con2 == 6) {
                lb.setText("Mi nombre es Juan Camilo Muñoz\n"
                        + " soy estudiante de tercer semestre de\n "
                        + "ingeniería de sistemas, tengo 21 años,\n"
                        + "egresado del Sena, salí graduado con honores\n"
                        + "en la tecnologia de programación\n"
                        + "actualmente vivo con mis padres en la ciudad de medellin.");
            } else if (con2 == 7) {
                lb.setText("Mi nombre es Jean Carlo Herrera Delgado soy estudiante de cuarto semestre de ingeniería de sistemas\n"
                        + "tengo 21 años,soy músico-compositor y cocreador de la banda young blood, actualmente vivo en medellin pero mis padres resíden en Puerto Berrío.");
            } else if (con2 == 8) {
                lb.setText("Mi nombre es Santiago López Gallego, soy estudiante de tercer semestre de ingeniería de sistemas\n"
                        + "tengo 19 años, saxofonista de alto nivel para la banda EL Retiro. Actualmente resido en el Retiro.");
            } else if (con2 == 9) {
                lb.setText("Mi nombre es Juan Camilo Hoyos, soy estudiante de cuarto semestre de ingeniería de sistemas\n"
                        + "tengo 24 años, soy tecnólogo en gestión de redes egresado del Sena, vivo en medellín pero soy huilense. ");

            }
            miborderpane3_2.setCenter(lb);
            con2++;
        });
        
        descripcionbtn.setOnAction((event) -> {
            Label lb=new Label("DESCRIPCIÓN\n" +
"El gimnasio BodyArt recibe aproximadamente 150 clientes al día, ofrece varios tipos de productos: rutinas, dietas y suplementos dietarios. Los clientes pueden por medio de esta aplicación consultar algunos datos básicos, reservar en línea y registrarse. \n" +
"Nuestros empleados tienen control total de la gestión de actividades que se realizan en el gimnasio, tales como control de clientes, eventos e inventario disponible en la tienda de suplementos. \n" +
"El administrador puede agregar empleados, puede modificar permisos de algunos de ellos haciendo que la aplicación sea completamente focalizada en grupos, por tanto, es completamente adaptable a las necesidades propias de cada sucursal del gimnasio o de cualquier organización.");
            lb.setAlignment(Pos.TOP_LEFT);
            miborderpane.setCenter(lb);
        });
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Scene escenaInicial() {
        miborderpane = new BorderPane();
        miborderpane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        miborderpane.setPadding(new Insets(10, 10, 10, 10));

        
        HBox miHbox = new HBox();

        miHbox.getChildren().addAll(descripcionbtn, salirbtn);

//
//        migridpane.setBorder(new Border(new BorderStroke(Color.BLACK,
//                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//        migridpane.setPadding(new Insets(5, 5, 5, 5));
//        migridpane.setAlignment(Pos.CENTER);
//
        Label nombrelb = new Label("BodyArt");
        nombrelb.setTextFill(Color.web("WHITE"));
        nombrelb.setFont(new Font("Yu Gothic UI Semibold", 20));
        nombrelb.setTextAlignment(TextAlignment.CENTER);

//        
//        
//        
//        migridpane.add(nombrelb, 1, 1);
//        migridpane.add(salirbtn, 5, 1);
//        migridpane.add(descripcionbtn, 6, 1);
//        migridpane.setVgap(3);
//        migriedpane.setHgap(5);
        BorderPane root3 = new BorderPane();
        root3.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        root3.setLeft(nombrelb);
        root3.setRight(miHbox);
        root3.setPadding(new Insets(5, 5, 5, 5));
        miborderpane.setTop(root3);

        miborderpane.setTop(root3); //metimos primer grid a mi
        //hasta aca bien

        //MIBORDERPANER
        BorderPane organizador = new BorderPane();
        organizador.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        organizador.setPadding(new Insets(5, 5, 5, 5));
        miborderpane.setCenter(organizador);

        //segundo panel creado izquierdo.
        GridPane migridpane2 = new GridPane();
        migridpane2.setPadding(new Insets(10, 10, 10, 10));
        GridPane migridpane3 = new GridPane(); //segundo panel creado derecho.
        migridpane3.setPadding(new Insets(10, 10, 10, 10));
        migridpane3.setMaxWidth(Double.MAX_VALUE);
        migridpane3.getColumnConstraints().add(new ColumnConstraints(300));
       
        
        
        organizador.setLeft(migridpane2);
        organizador.setRight(migridpane3);
        organizador.setCenter(null);

        migridpane3.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        migridpane2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        //MIGRIDPANE2
        GridPane migridpane2_2 = new GridPane();
        BorderPane miborderpane2_1 = new BorderPane(); //border de saludo.
        migridpane2.add(miborderpane2_1, 0, 0); //anidamos 
        migridpane2.add(migridpane2_2, 0, 1); //anidamos
        migridpane2.setVgap(5);
        migridpane2.setHgap(5);

        //borderpane2_1
        Label saludobl = new Label("Bienvenido a BodyArt"
                + "\nLugar donde aprenderas"
                + "\nque no siempre es fácil, "
                + "\npero vale la pena.");
        saludobl.setTextAlignment(TextAlignment.CENTER);
        saludobl.setTextFill(Color.web("WHITE"));
        saludobl.setFont(new Font("Corbel Light", 20));
        miborderpane.setStyle("-fx-background-color: #006699;");

        miborderpane2_1.setCenter(saludobl);

        miborderpane2_1.setPadding(new Insets(10, 10, 10, 10));

        //Gridpane2_2
        usuariotf = new TextField();
        contraseñatf = new PasswordField();

        migridpane2_2.add(usuariotf, 0, 0);
        migridpane2_2.add(contraseñatf, 1, 0);
        migridpane2_2.add(ingresarbtn, 0, 1);
        migridpane2_2.add(registrarsebtn, 0, 3);

        migridpane2_2.setHgap(3);
        migridpane2_2.setVgap(3);

        //colocar lineas chimbas
        migridpane2_2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        migridpane2_2.setPadding(new Insets(10, 10, 10, 10));

        //GRIDPANE3
        migridpane3.add(miborderpane3_1, 0, 0);
        migridpane3.add(miborderpane3_2, 0, 1);
        miborderpane3_1.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        miborderpane3_2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Image img = new Image("imagenes/1.jpg");
        ImageView imgv = new ImageView(img);
        imgv.setFitWidth(200);
        imgv.setFitHeight(200);
        miborderpane3_1.setCenter(imgv);
        miborderpane3_1.setPadding(new Insets(10, 10, 10, 10));
        miborderpane3_2.setPadding(new Insets(10, 10, 10, 10));

        Image img2 = new Image("imagenes/6.jpg");
        ImageView imgv2 = new ImageView(img2);
        imgv2.setFitWidth(90);
        imgv2.setFitHeight(90);
//            HBox hbx = new HBox();
//            hbx.getChildren().add(imgv);
//            StackPane stp = new StackPane();
//            stp.getChildren().addAll(new Label("Nombre: "), new Label("Edad: "), new Label("Genero: "));
//            hbx.getChildren().add(stp);
        miborderpane3_2.setTop(imgv2);
        Label lb = new Label("Mi nombre es Juan Camilo Muñoz soy estudiante de tercer semestre de ingeniería de sistemas\n"
                + "tengo 21 años, egresado del Sena, salí graduado con honores en la tecnologia de programación\n"
                + "actualmente vivo con mis padres en la ciudad de medellin.");
        lb.setMaxWidth(200);
        lb.setTextFill(Color.web("WHITE"));
        lb.setTextAlignment(TextAlignment.JUSTIFY);
        lb.setContentDisplay(ContentDisplay.LEFT);
        miborderpane3_2.setCenter(lb);

        return new Scene(miborderpane, 700, 500);
    }

    public Scene escenaUsuario() {
        BorderPane root = new BorderPane();

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Label userlb = new Label("Usuario: " + new MenuDeConsola().getSesion().getNombre());

        BorderPane root3 = new BorderPane();
        root3.setLeft(userlb);
        root3.setRight(salirbtn);
        root3.setPadding(new Insets(5, 5, 5, 5));
        root.setTop(root3);

        centro = new BorderPane();

        GridPane root2 = new GridPane();
        archivobtn = new Button("Archivo");

        archivobtn.setOnAction((event) -> {
            Usuario user = new MenuDeConsola().getSesion();
//            Usuario user = new Cliente("1193", "Slg", "1193", 19, 68, 170, "m", "541");
            FieldPanel fieldPanel = null;
            if (user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                String criterios[] = {"Cédula", "Nombre", "Contraseña", "Peso", "Estatura", "Edad", "Genero", "Telefono"};
                String valores[] = {cliente.getCedula(), cliente.getNombre(), cliente.getContrasena(), String.valueOf(cliente.getPeso()), String.valueOf(cliente.getEstatura()), String.valueOf(cliente.getEdad()), cliente.getGenero(), cliente.getTelefono()};
                boolean estado[] = {false, true, true, true, true, true, true, true,};
                fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
            } else if (user instanceof Administrador) {
//                Administrador admin = (Administrador) user;
                String criterios[] = {"Cédula", "Nombre", "Contraseña"};
                String valores[] = {user.getCedula(), user.getNombre(), user.getContrasena()};
                boolean estado[] = {false, true, true};
                fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
            }
            centro.setCenter(fieldPanel.getGrid());
        });

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
        return new Scene(root, 600, 400);
    }

    class HandlerProcesos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            FlowPane opciones = new FlowPane(Orientation.VERTICAL);
            opciones.setVgap(5);
            opciones.setHgap(20);
            ArrayList<String> listaMenu = new MenuDeConsola().getListaMenu();
            for (String opcionDeMenu : listaMenu) {
                Hyperlink linkOpcion = new Hyperlink(opcionDeMenu);
                opciones.getChildren().add(linkOpcion);
            }

//            calcularPesoIdealbtn = new Button("Calcular peso ideal");
//            Button imprimirAlgobtn = new Button("Calcular IMC");
//            opciones.getChildren().addAll(imprimirAlgobtn, new Button("TMB"), new Button("Dieta"), calcularPesoIdealbtn);
//
//            calcularPesoIdealbtn.setOnAction(new HandlerCalcularPesoIdeal());
//            imprimirAlgobtn.setOnAction(new HandlerImprimirAlgo());
            centro.setCenter(opciones);

            //Slg
        }
    }

    class HandlerAyuda implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("\nAutores del proyecto: "
                    + "\nJuan Camilo Muñoz López"
                    + "\nJuan Camilo Hoyos Peña"
                    + "\nYanka LDS Herrera Delgado"
                    + "\nSantiago López Gallego\"");
            alert.show();
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
