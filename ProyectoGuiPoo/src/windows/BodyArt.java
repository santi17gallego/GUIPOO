package windows;

import gestorAplicacion.paquete1.Administrador;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
import gestorAplicacion.paquete1.Vendedor;
import gestorAplicacion.paquete2.Suplemento;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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

    public BorderPane getCentro() {
        return centro;
    }
    private Menu menuArchivo;
    private Menu menuProcesos = new Menu("Procesos y consultas");
    private Menu menuAyuda;
    private MenuItem menuItemUsuario;
    private MenuItem menuItemSalir = new MenuItem("Salir");
    private MenuItem ConsultarPeso_Ideal;
    private MenuItem menuAutores;

    private Button salirbtn = new Button("Salir");
    //slg
    private Button enviarParametrobtn;
    private Button enviarbtn;

    Button registrarsebtn = new Button("Registrarse");
    Label informacion;

    TextField campo;
    TextField campo2;
    BorderPane miborderpane = new BorderPane();
    BorderPane miborderpane3_1 = new BorderPane();
    public TextArea resultadota;
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
            Label lb = new Label("DESCRIPCIÓN\n"
                    + "El gimnasio BodyArt recibe aproximadamente 150 clientes al día, ofrece varios tipos de productos: rutinas, dietas y suplementos dietarios. Los clientes pueden por medio de esta aplicación consultar algunos datos básicos, reservar en línea y registrarse. \n"
                    + "Nuestros empleados tienen control total de la gestión de actividades que se realizan en el gimnasio, tales como control de clientes, eventos e inventario disponible en la tienda de suplementos. \n"
                    + "El administrador puede agregar empleados, puede modificar permisos de algunos de ellos haciendo que la aplicación sea completamente focalizada en grupos, por tanto, es completamente adaptable a las necesidades propias de cada sucursal del gimnasio o de cualquier organización.");
            lb.setAlignment(Pos.TOP_LEFT);
            miborderpane.setCenter(lb);
        });
        menuItemSalir.setOnAction((event) -> {
            new MenuDeConsola().cerrarSesion();
            menuProcesos = new Menu("Procesos y consultas");
            primaryStage.setScene(escenaInicial());

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
        //archivobtn = new Button("Archivo");

        menuArchivo = new Menu("Archivo");
        menuItemUsuario = new MenuItem("Usuario");
        menuAyuda = new Menu("Ayuda");
        menuAutores = new MenuItem("Autores");
        menuArchivo.getItems().addAll(menuItemUsuario, menuItemSalir);
        menuAyuda.getItems().add(menuAutores);

        try {
            ArrayList<String> listaMenu = new MenuDeConsola().getListaMenu();
            for (String opcionDeMenu : listaMenu) {
                //Hyperlink linkOpcion = new Hyperlink(opcionDeMenu);
                MenuItem metodo = new MenuItem(opcionDeMenu);
//                Class<?> clase = Class.forName("windows.BodyArt");
//                Object instanceClase = clase.newInstance();
//
//                Class<?> innerClase = Class.forName("windows.BodyArt$" + opcionDeMenu);
//                Constructor<?> ctor = innerClase.getDeclaredConstructor(clase);
//
//                Object innerInstance = ctor.newInstance(instanceClase);
//                metodo.setOnAction((EventHandler<ActionEvent>) innerInstance);
                if (opcionDeMenu.equals("ConsultarPesoIdeal")) {
                    metodo.setOnAction(new ConsultarPesoIdeal());
                } else if (opcionDeMenu.equals("ConsultarCaloriasQuemadas")) {
                    metodo.setOnAction(new ConsultarCaloriasQuemadas());
                } else if (opcionDeMenu.equals("ConsultarRutina")) {
                    metodo.setOnAction(new ConsultarRutina());
                } else if (opcionDeMenu.equals("ConsultarDieta")) {
                    metodo.setOnAction(new ConsultarDieta());
                } else if (opcionDeMenu.equals("ConsultarInventario")) {
                    metodo.setOnAction(new ConsultarInventario());
                }
                //metodo.setOnAction((EventHandler<ActionEvent>) Class.forName("windows."+opcionDeMenu).newInstance());
                menuProcesos.getItems().add(metodo);
            }

        } catch (Exception ex) {
            ex.getStackTrace();
        }
        MenuBar barraMenu = new MenuBar();
        barraMenu.getMenus().addAll(menuArchivo, menuProcesos, menuAyuda);
        root2.add(barraMenu, 0, 0);

        menuItemUsuario.setOnAction((event) -> {
            Usuario user = new MenuDeConsola().getSesion();
//            Usuario user = new Cliente("1193", "Slg", "1193", 19, 68, 170, "m", "541");
            FieldPanel fieldPanel = null;
            if (user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                String criterios[] = {"Cédula", "Nombre", "Contraseña", "Peso", "Estatura", "Edad", "Genero", "Telefono"};
                String valores[] = {cliente.getCedula(), cliente.getNombre(), cliente.getContrasena(), String.valueOf(cliente.getPeso()), String.valueOf(cliente.getEstatura()), String.valueOf(cliente.getEdad()), cliente.getGenero(), cliente.getTelefono()};
                boolean estado[] = {false, true, true, true, true, true, true, true,};
                fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
            } else {
                String criterios[] = {"Cédula", "Nombre", "Contraseña"};
                String valores[] = {user.getCedula(), user.getNombre(), user.getContrasena()};
                boolean estado[] = {false, true, true};
                fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
            }
            GridPane grid = fieldPanel.getGrid();
            Button borrarbtn=new Button("Borrar");
            Button enviarbtn=new Button("Enviar");
            grid.addColumn(0, borrarbtn);
            grid.addColumn(1, enviarbtn);
            
            centro.setCenter(grid);
            
            enviarbtn.setOnAction((event2) -> {
                Usuario user1=new MenuDeConsola().getSesion();
                if(user1 instanceof Cliente){
                    //Cliente cliente = new Cliente(fieldPanel.getValue("Documento"), STYLESHEET_MODENA, STYLESHEET_MODENA, con, con, pesoEntero, STYLESHEET_MODENA, STYLESHEET_MODENA);
                }
            });
            
        });

        menuAutores.setOnAction(new HandlerAyuda());

        root2.setPadding(new Insets(5, 5, 5, 5));
        root2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        centro.setTop(root2);
        centro.setPadding(new Insets(5, 5, 5, 5));
        centro.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        centro.setCenter(form);
        root.setCenter(centro);
        return new Scene(root, 600, 500);
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
    class ConsultarPesoIdeal implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            FlowPane general = new FlowPane(Orientation.VERTICAL);
            general.setAlignment(Pos.CENTER);
            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(5);
            calcularPesoIdeal.setHgap(5);
            general.setVgap(5);
            general.setHgap(5);
            calcularPesoIdeal.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            calcularPesoIdeal.setPadding(new Insets(5, 5, 5, 5));
            Label nombreProcesolb = new Label("Calcular peso ideal");
            Label descripcionProcesolb = new Label("Simplemente agregando la estatura, !podemos imprimir tu peso ideal!");
            nombreProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            nombreProcesolb.setPadding(new Insets(5, 5, 5, 5));
            descripcionProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            descripcionProcesolb.setPadding(new Insets(5, 5, 5, 5));
            nombreProcesolb.setMaxWidth(Double.MAX_VALUE);
            descripcionProcesolb.setMaxWidth(Double.MAX_VALUE);
            general.setLayoutX(Double.MAX_VALUE);
            general.setLayoutY(Double.MAX_VALUE);
            nombreProcesolb.setAlignment(Pos.CENTER);
            descripcionProcesolb.setAlignment(Pos.CENTER);
            informacion = new Label("Digite su estatura");
            campo = new TextField();
            enviarbtn = new Button("Enviar");
            enviarParametrobtn = new Button("Calcular peso ideal");
            resultadota = new TextArea();
            calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, resultadota);
            general.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            centro.setCenter(general);

            enviarbtn.setOnAction(new HandlerEnviarPeso());

        }
    }

    class HandlerEnviarPeso implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String parametro = campo.getText();
            resultadota.setText(new Cliente().pesoIdeal(Float.parseFloat(parametro)));
        }
    }

    class ConsultarCaloriasQuemadas implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            FlowPane general = new FlowPane(Orientation.VERTICAL);
            general.setAlignment(Pos.CENTER);
            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(5);
            calcularPesoIdeal.setHgap(5);
            general.setVgap(5);
            general.setHgap(5);
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
            general.setLayoutX(Double.MAX_VALUE);
            general.setLayoutY(Double.MAX_VALUE);
            nombreProcesolb.setAlignment(Pos.CENTER);
            descripcionProcesolb.setAlignment(Pos.CENTER);
            informacion = new Label("Digite distancia recorrida");
            campo = new TextField();
            enviarbtn = new Button("Enviar");
            resultadota = new TextArea();
            calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, resultadota);
            general.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            centro.setCenter(general);
            enviarbtn.setOnAction(new HandlerEnviarDistancia());

        }
    }

    class HandlerEnviarDistancia implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Cliente cliente = (Cliente) new MenuDeConsola().getSesion();
            String parametro = campo.getText();
            resultadota.setText(cliente.calcularkcaloriasquemadas(Integer.parseInt(parametro)));
        }
    }

    class ConsultarRutina implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            FlowPane general = new FlowPane(Orientation.VERTICAL);
            general.setAlignment(Pos.CENTER);
            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(5);
            calcularPesoIdeal.setHgap(5);
            general.setVgap(5);
            general.setHgap(5);
            calcularPesoIdeal.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            calcularPesoIdeal.setPadding(new Insets(5, 5, 5, 5));
            Label nombreProcesolb = new Label("Calcular rutina");
            Label descripcionProcesolb = new Label("Al proporcionar la cédula del cliente, generaremos una rutina adecuada\n"
                    + "para nuestro cliente seleccionado.\n"
                    + "Además cada rutina es única y especial para cada uno. ");
            nombreProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            nombreProcesolb.setPadding(new Insets(5, 5, 5, 5));
            descripcionProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            descripcionProcesolb.setPadding(new Insets(5, 5, 5, 5));
            nombreProcesolb.setMaxWidth(Double.MAX_VALUE);
            descripcionProcesolb.setMaxWidth(Double.MAX_VALUE);
            general.setLayoutX(Double.MAX_VALUE);
            general.setLayoutY(Double.MAX_VALUE);
            nombreProcesolb.setAlignment(Pos.CENTER);
            descripcionProcesolb.setAlignment(Pos.CENTER);
            informacion = new Label("Digite la cédula del cliente");
            campo = new TextField();
            enviarbtn = new Button("Enviar");
            resultadota = new TextArea();
            calcularPesoIdeal.getChildren().addAll(informacion, campo, enviarbtn, resultadota);
            general.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            centro.setCenter(general);

            enviarbtn.setOnAction(new HandlerEnviarConsultarRutina());

        }
    }

    class HandlerEnviarConsultarRutina implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Instructor instructor = (Instructor) new MenuDeConsola().getSesion();
            String parametro = campo.getText();
            Cliente cliente = instructor.consultarCliente(parametro);
            resultadota.setText(instructor.calcularRutina(cliente));
        }
    }

    class ConsultarDieta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            FlowPane general = new FlowPane(Orientation.VERTICAL);
            general.setAlignment(Pos.CENTER);
            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(5);
            calcularPesoIdeal.setHgap(5);
            general.setVgap(5);
            general.setHgap(5);
            calcularPesoIdeal.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            calcularPesoIdeal.setPadding(new Insets(5, 5, 5, 5));
            Label nombreProcesolb = new Label("Consultar dieta");
            Label descripcionProcesolb = new Label("Al proporcionar la cédula del cliente, generaremos una rutina adecuada\n"
                    + "para nuestro cliente seleccionado.\n"
                    + "Además cada rutina es única y especial para cada uno. ");
            nombreProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            nombreProcesolb.setPadding(new Insets(5, 5, 5, 5));
            descripcionProcesolb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            descripcionProcesolb.setPadding(new Insets(5, 5, 5, 5));
            nombreProcesolb.setMaxWidth(Double.MAX_VALUE);
            descripcionProcesolb.setMaxWidth(Double.MAX_VALUE);
            general.setLayoutX(Double.MAX_VALUE);
            general.setLayoutY(Double.MAX_VALUE);
            nombreProcesolb.setAlignment(Pos.CENTER);
            descripcionProcesolb.setAlignment(Pos.CENTER);
            campo = new TextField();
            campo.setPromptText("Cédula del cliente");
            campo2 = new TextField();
            campo2.setPromptText("Cantidad de ejercicio");
            enviarbtn = new Button("Enviar");
            resultadota = new TextArea();
            resultadota.setText("Ingrese cantidad de ejercicio (si es poco: 2 o menos días (digite 1)\n"
                    + "Si es ligero: 3 días (digite 2)\n"
                    + "Si es moderado: 3-5 días (digite 3)\n"
                    + "Si es deportista: 6-7 días (digite 4)\n"
                    + "Si es atleta: 7 días mañana y tarde (digite 5)");
            calcularPesoIdeal.getChildren().addAll(campo, campo2, enviarbtn, resultadota);
            general.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            centro.setCenter(general);

            enviarbtn.setOnAction(new HandlerEnviarConsultarDieta());

        }
    }

    class HandlerEnviarConsultarDieta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Instructor instructor = (Instructor) new MenuDeConsola().getSesion();
            String parametro = campo.getText();
            String parametro2 = campo2.getText();
            Cliente cliente = instructor.consultarCliente(parametro);
            resultadota.setText(instructor.calcularDieta(cliente, parametro2));
        }
    }

    class ConsultarInventario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            FlowPane general = new FlowPane(Orientation.VERTICAL);
            general.setAlignment(Pos.CENTER);
            FlowPane calcularPesoIdeal = new FlowPane();
            calcularPesoIdeal.setVgap(5);
            calcularPesoIdeal.setHgap(5);
            general.setVgap(5);
            general.setHgap(5);
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
            general.setLayoutX(Double.MAX_VALUE);
            general.setLayoutY(Double.MAX_VALUE);
            nombreProcesolb.setAlignment(Pos.CENTER);
            descripcionProcesolb.setAlignment(Pos.CENTER);
            campo = new TextField();
            enviarbtn = new Button("Consultar inventario");
            resultadota = new TextArea();
            calcularPesoIdeal.getChildren().addAll(enviarbtn, resultadota);
            general.getChildren().addAll(nombreProcesolb, descripcionProcesolb, calcularPesoIdeal);

            centro.setCenter(general);

            enviarbtn.setOnAction(new HandlerEnviarConsultarInventario());

        }
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
