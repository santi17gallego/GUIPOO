package windows;

/*
 * Modulo principal del proyecto.
 * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
 */
import Excepciones.CampoVacio;
import Excepciones.CaracterInvalido;
import Excepciones.CedulaOContrasenaInvalida;
import gestorAplicacion.paquete1.Administrador;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
import gestorAplicacion.paquete1.Vendedor;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import uiMain.menuConsola.MenuDeConsola;
import windows.Administrador.AgregarPermisos;
import windows.Administrador.ConsultarPermisos;
import windows.Administrador.ConsultarTodosLosPermisos;
import windows.Administrador.EliminarPermisos;
import windows.Administrador.EliminarUsuario;
import windows.Administrador.RegistrarUsuario;
import windows.Cliente.ConsultarCaloriasQuemadas;
import windows.Cliente.ConsultarPesoIdeal;
import windows.Instructor.ConsultarDieta;
import windows.Instructor.ConsultarRutina;
import windows.Vendedor.ConsultarInventario;


/*
 * Clase aplicación principal del proyecto.
 * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
 */
public class BodyArt extends Application {

    private BorderPane centro;

    private Menu menuArchivo;
    private Menu menuProcesos = new Menu("Procesos y consultas");
    private Menu menuAyuda;
    private MenuItem menuItemUsuario;
    private MenuItem menuItemSalir = new MenuItem("Salir");
    private MenuItem menuAutores;

    private Button salirbtn = new Button("Salir");

    private Button registrarsebtn = new Button("Registrarse");

    private BorderPane miborderpane = new BorderPane();
    private BorderPane miborderpane3_1 = new BorderPane();
    private BorderPane miborderpane3_2 = new BorderPane();

    //Login
    private Button ingresarbtn = new Button("Ingresar");
    private TextField usuariotf;
    private TextField contraseñatf;
    private Button descripcionbtn = new Button("Descripcion");
    private static int con = 1, con2 = 7;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Body Art");
        Scene primeraescena = escenaInicial();

        primaryStage.setScene(primeraescena);
        primaryStage.show();

        ingresarbtn.setOnAction((event) -> {
            String usuario = usuariotf.getText();
            String contrasena = contraseñatf.getText();
            try {
                Object array[] = Usuario.iniciarSesion(usuario, contrasena);
                new MenuDeConsola().setSesion((Usuario) array[0]);
                MenuDeConsola.crearMenu((String[]) array[1]);
                primaryStage.setScene(escenaUsuario());
            } catch (CedulaOContrasenaInvalida ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }

        });

        registrarsebtn.setOnAction((event) -> {
            String criterios[] = {"Cédula", "Nombre", "Contraseña", "Peso", "Estatura", "Edad", "Genero", "Telefono"};
            String valores[] = null;
            boolean estado[] = null;
            FieldPanel fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);

            GridPane migrid = fieldPanel.getGrid();
            Button registrarseEnviar = new Button("Registrarse");
            migrid.addColumn(1, registrarseEnviar);
            migrid.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            migrid.setPadding(new Insets(10, 10, 10, 10));
            miborderpane.setCenter(migrid);

            registrarseEnviar.setOnAction((event1) -> {
                ArrayList<TextField> textFieldList = fieldPanel.getTextFieldList();
                String camposVacios = "";
                for (int i = 0; i < textFieldList.size(); i++) {
                    TextField textF = textFieldList.get(i);
                    if (textF.getText().equals("")) {
                        camposVacios = camposVacios + textF.getId() + "\n";
                    }
                }
                try {
                    if (!camposVacios.equals("")) {
                        throw new CampoVacio();
                    }
                    try {
                        String genero = textFieldList.get(6).getText();
                        if (!(genero.equals("f") || genero.equals("m"))) {
                            throw new CaracterInvalido();
                        }
                        Cliente cliente = new Cliente(textFieldList.get(0).getText(), textFieldList.get(1).getText(), textFieldList.get(2).getText(), Integer.parseInt(textFieldList.get(5).getText()), Float.parseFloat(textFieldList.get(3).getText()), Float.parseFloat(textFieldList.get(4).getText()), genero, textFieldList.get(7).getText());
                        if (Cliente.registrarse(cliente)) {
                            new MenuDeConsola().setSesion(cliente);
                            String lista[] = {"ConsultarPesoIdeal", "ConsultarCaloriasQuemadas"};
                            MenuDeConsola.crearMenu(lista);
                            primaryStage.setScene(escenaUsuario());
                        } else {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setContentText("Error al registrarse.");
                            alerta.show();
                        }
                    } catch (CaracterInvalido ex) {
                        new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
                    }
                } catch (CampoVacio e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage() + "\nCampos vacios:\n" + camposVacios);
                    alert.show();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error de formato en algún campo del formulario.");
                    alert.show();
                }

                //Button atrasbtn = new Button("Atrás");
            });
        });
        salirbtn.setOnAction((event) -> {
            //primaryStage.setScene(escenaInicial());
            primaryStage.close();
        });

        miborderpane3_1.setOnMouseEntered((event) -> {
            if (con == 6) {
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
            BorderPane imgvPane = new BorderPane();
            imgvPane.setCenter(imgv);
            miborderpane3_2.setTop(imgvPane);
            Label lb = new Label();
            lb.setMaxWidth(200);
            lb.setTextFill(Color.web("WHITE"));
            switch (con2) {
                case 6:
                    lb.setText("Mi nombre es Juan Camilo Muñoz"
                            + " soy estudiante de tercer semestre de "
                            + "ingeniería de sistemas, tengo 21 años, "
                            + "soy egresado del Sena en analisís y desarrollo de sistemas de información"
                            + ", actualmente vivo en la ciudad de Medellín.");
                    break;
                case 7:
                    lb.setText("Mi nombre es Jean Carlo Herrera Delgado soy estudiante de cuarto semestre de ingeniería de sistemas "
                            + "tengo 21 años, soy músico, compositor y cocreador de la banda young blood, actualmente vivo en medellin pero mis padres resíden en Puerto Berrío.");
                    break;
                case 8:
                    lb.setText("Mi nombre es Santiago López Gallego, soy estudiante de tercer semestre de ingeniería de sistemas "
                            + "tengo 19 años, saxofonista de alto nivel para la banda EL Retiro. Actualmente resido en el Retiro.");
                    break;
                case 9:
                    lb.setText("Mi nombre es Juan Camilo Hoyos, soy estudiante de cuarto semestre de ingeniería de sistemas "
                            + "tengo 24 años, soy tecnólogo en gestión de redes egresado del Sena, vivo en medellín pero soy huilense. ");
                    break;
                default:
                    break;
            }
            lb.setWrapText(true);
            miborderpane3_2.setCenter(lb);
            con2++;
        });

        descripcionbtn.setOnAction((event) -> {
            Label lb = new Label("DESCRIPCIÓN\n"
                    + "El gimnasio BodyArt recibe aproximadamente 150 clientes al día, ofrece varios tipos de productos: rutinas, dietas y suplementos dietarios. Los clientes pueden por medio de esta aplicación consultar algunos datos básicos, reservar en línea y registrarse. \n"
                    + "Nuestros empleados tienen control total de la gestión de actividades que se realizan en el gimnasio, tales como control de clientes, eventos e inventario disponible en la tienda de suplementos. \n"
                    + "El administrador puede agregar empleados, puede modificar permisos de algunos de ellos haciendo que la aplicación sea completamente focalizada en grupos, por tanto, es completamente adaptable a las necesidades propias de cada sucursal del gimnasio o de cualquier organización.");
            lb.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            lb.setTextFill(Color.web("WHITE"));
            lb.setFont(new Font("Yu Gothic UI Semibold", 15));
            lb.setTextAlignment(TextAlignment.JUSTIFY);
            lb.setWrapText(true);
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

    /*
    * Este metodo retorna la escena inicial(login) de la aplicación.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    private Scene escenaInicial() {
        miborderpane = new BorderPane();
        miborderpane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        miborderpane.setPadding(new Insets(10, 10, 10, 10));

        HBox miHbox = new HBox();

        miHbox.getChildren().addAll(descripcionbtn, salirbtn);

        Label nombrelb = new Label("BodyArt");
        nombrelb.setTextFill(Color.web("WHITE"));
        nombrelb.setFont(new Font("Yu Gothic UI Semibold", 20));
        nombrelb.setTextAlignment(TextAlignment.CENTER);

        BorderPane root3 = new BorderPane();
        root3.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        root3.setLeft(nombrelb);
        root3.setRight(miHbox);
        root3.setPadding(new Insets(5, 5, 5, 5));
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
        miborderpane.setStyle("-fx-background-color: #3B98F1;");

        miborderpane2_1.setCenter(saludobl);

        miborderpane2_1.setPadding(new Insets(10, 10, 10, 10));

        //Gridpane2_2
        usuariotf = new TextField();
        usuariotf.setPromptText("Cedula");
        contraseñatf = new PasswordField();
        contraseñatf.setPromptText("Contraseña");

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
        BorderPane imgvPane = new BorderPane();
        imgvPane.setCenter(imgv2);
        miborderpane3_2.setTop(imgvPane);
        Label lb = new Label("Mi nombre es Juan Camilo Muñoz"
                + " soy estudiante de tercer semestre de "
                + "ingeniería de sistemas, tengo 21 años, "
                + "soy egresado del Sena en analisís y desarrollo de sistemas de información"
                + ", actualmente vivo en la ciudad de Medellín.");
        lb.setMaxWidth(200);
        lb.setTextFill(Color.web("WHITE"));
        lb.setTextAlignment(TextAlignment.JUSTIFY);
        lb.setWrapText(true);
        miborderpane3_2.setCenter(lb);

        return new Scene(miborderpane, 800, 600);
    }
    
    /*
    * Este metodo retorna la escena del usuario de la aplicación.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
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

        menuArchivo = new Menu("Archivo");
        menuItemUsuario = new MenuItem("Usuario");
        menuAyuda = new Menu("Ayuda");
        menuAutores = new MenuItem("Autores");
        menuArchivo.getItems().addAll(menuItemUsuario, menuItemSalir);
        menuAyuda.getItems().add(menuAutores);

        try {
            MenuDeConsola menu = new MenuDeConsola();
            ArrayList<String> listaMenu = menu.getListaMenu();
            Usuario sesion = menu.getSesion();
            if (sesion instanceof Cliente) {
                for (String opcionDeMenu : listaMenu) {
                    MenuItem metodo = new MenuItem(opcionDeMenu);
                    if (opcionDeMenu.equals("ConsultarPesoIdeal")) {
                        metodo.setOnAction(new HandlerConsultarPesoIdeal());
                    } else if (opcionDeMenu.equals("ConsultarCaloriasQuemadas")) {
                        metodo.setOnAction(new HandlerConsultarCaloriasQuemadas());
                    }
                    menuProcesos.getItems().add(metodo);
                }
            } else if (sesion instanceof Instructor) {
                for (String opcionDeMenu : listaMenu) {
                    MenuItem metodo = new MenuItem(opcionDeMenu);
                    if (opcionDeMenu.equals("ConsultarRutina")) {
                        metodo.setOnAction(new HandlerConsultarRutina());
                    } else if (opcionDeMenu.equals("ConsultarDieta")) {
                        metodo.setOnAction(new HandlerConsultarDieta());
                    }
                    menuProcesos.getItems().add(metodo);
                }
            } else if (sesion instanceof Vendedor) {
                for (String opcionDeMenu : listaMenu) {
                    MenuItem metodo = new MenuItem(opcionDeMenu);
                    if (opcionDeMenu.equals("ConsultarInventario")) {
                        metodo.setOnAction(new HandlerConsultarInventario());
                    }
                    menuProcesos.getItems().add(metodo);
                }
            } else {
                for (String opcionDeMenu : listaMenu) {
                    MenuItem metodo = new MenuItem(opcionDeMenu);
                    if (opcionDeMenu.equals("ConsultarTodosLosPermisos")) {
                        metodo.setOnAction(new HandlerConsultarTodosLosPermisos());
                    } else if (opcionDeMenu.equals("RegistrarUsuario")) {
                        metodo.setOnAction(new HandlerRegistrarUsuario());
                    } else if (opcionDeMenu.equals("EliminarUsuario")) {
                        metodo.setOnAction(new HandlerEliminarUsuario());
                    } else if (opcionDeMenu.equals("ConsultarPermisos")) {
                        metodo.setOnAction(new HandlerConsultarPermisos());
                    } else if (opcionDeMenu.equals("AgregarPermisos")) {
                        metodo.setOnAction(new HandlerAgregarPermisos());
                    } else if (opcionDeMenu.equals("EliminarPermisos")) {
                        metodo.setOnAction(new HandlerEliminarPermisos());
                    }
                    menuProcesos.getItems().add(metodo);
                }
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
            Button borrarbtn = new Button("Borrar");
            Button guardarbtn = new Button("Guardar");
            grid.addColumn(0, borrarbtn);
            grid.addColumn(1, guardarbtn);

            centro.setCenter(grid);
            ArrayList<TextField> textFieldList = fieldPanel.getTextFieldList();

            guardarbtn.setOnAction((event2) -> {

                String camposVacios = "";

                for (int i = 0; i < textFieldList.size(); i++) {
                    TextField textF = textFieldList.get(i);
                    if (textF.getText().equals("")) {
                        camposVacios = camposVacios + textF.getId() + "\n";
                    }
                }
                try {
                    String genero = textFieldList.get(6).getText();
                    if (!(genero.equals("f") || genero.equals("m"))) {
                        throw new CaracterInvalido();
                    }
                    if (!camposVacios.equals("")) {
                        throw new CampoVacio();
                    }
                    Usuario user1 = new MenuDeConsola().getSesion();
                    boolean respuesta = false;
                    if (user1 instanceof Cliente) {
                        Cliente cliente = new Cliente(textFieldList.get(0).getText(), textFieldList.get(1).getText(), textFieldList.get(2).getText(), Integer.parseInt(textFieldList.get(5).getText()), Float.parseFloat(textFieldList.get(3).getText()), Float.parseFloat(textFieldList.get(4).getText()), textFieldList.get(6).getText(), textFieldList.get(7).getText());
                        new MenuDeConsola().setSesion(cliente);
                        respuesta = Usuario.ModificarUsuario(cliente);
                    } else if (user1 instanceof Administrador) {
                        respuesta = Usuario.ModificarUsuario(new Administrador(textFieldList.get(1).getText(), textFieldList.get(0).getText(), textFieldList.get(2).getText()));
                    } else if (user1 instanceof Instructor) {
                        respuesta = Usuario.ModificarUsuario(new Instructor(textFieldList.get(1).getText(), textFieldList.get(0).getText(), textFieldList.get(2).getText()));
                    } else {
                        respuesta = Usuario.ModificarUsuario(new Vendedor(textFieldList.get(1).getText(), textFieldList.get(0).getText(), textFieldList.get(2).getText()));
                    }
                    if (respuesta) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                        alerta.setContentText("Datos guardados correctamente");
                        alerta.show();
                    } else {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setContentText("Error al modificar los datos.");
                        alerta.show();
                    }

                } catch (CampoVacio e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage() + "\nCampos vacios:\n" + camposVacios);
                    alert.show();
                } catch (CaracterInvalido ex) {
                    new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error de formato en algún campo del formulario.");
                    alert.show();
                }

            }
            );

            borrarbtn.setOnAction((event3) -> {
                for (int i = 1; i < textFieldList.size(); i++) {
                    textFieldList.get(i).setText("");
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
    /*
    * Esta clase se encarga de escuchar a menuAyuda.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerAyuda implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("\nAutores del proyecto: "
                    + "\nJuan Camilo Muñoz López"
                    + "\nJuan Camilo Hoyos Peña"
                    + "\nJean Carlo Herrera Delgado"
                    + "\nSantiago López Gallego\");
            alert.show();
        }
    }

    /*
    * Esta clase se encarga de escuchar al menuItem ColsutarPesoIdeal.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarPesoIdeal implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            ConsultarPesoIdeal pesoIdeal = new ConsultarPesoIdeal();
            centro.setCenter(pesoIdeal);
        }
    }

        /*
    * Esta clase se encarga de escuchar al menuItem ConsultarCaloriasQuemadas.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarCaloriasQuemadas implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            ConsultarCaloriasQuemadas ConsultarCaloriassQuemadas = new ConsultarCaloriasQuemadas();
            centro.setCenter(ConsultarCaloriassQuemadas);

        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem ConsultarRutina.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarRutina implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            ConsultarRutina RutinaIdeal = new ConsultarRutina();
            centro.setCenter(RutinaIdeal);

        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem ConsultarDieta.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarDieta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            ConsultarDieta DietaIdeal = new ConsultarDieta();
            centro.setCenter(DietaIdeal);

        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem ConsultarInventario.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarInventario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            ConsultarInventario InventarioIdeal = new ConsultarInventario();
            centro.setCenter(InventarioIdeal);
        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem ConsultarTodosLosPermisos.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarTodosLosPermisos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            ConsultarTodosLosPermisos todosLosPermisos = new ConsultarTodosLosPermisos();
            centro.setCenter(todosLosPermisos);
        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem RegistrarUsuario.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerRegistrarUsuario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            RegistrarUsuario registrarUsuario = new RegistrarUsuario();
            centro.setCenter(registrarUsuario);
        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem EliminarUsuario.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerEliminarUsuario implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            EliminarUsuario eliminarUsuario = new EliminarUsuario();
            centro.setCenter(eliminarUsuario);
        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem ConsultarPermisos.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerConsultarPermisos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            ConsultarPermisos consultarPermisos = new ConsultarPermisos();
            centro.setCenter(consultarPermisos);
        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem AgregarPermisos.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerAgregarPermisos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            AgregarPermisos agregarPermisos = new AgregarPermisos();
            centro.setCenter(agregarPermisos);
        }
    }
/*
    * Esta clase se encarga de escuchar al menuItem EliminarPermisos.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
    class HandlerEliminarPermisos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            EliminarPermisos eliminarPermisos = new EliminarPermisos();
            centro.setCenter(eliminarPermisos);
        }
    }
}
