package windows.Administrador;
/*
    * Este modulo se encarga de registrar usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
import Excepciones.CampoVacio;
import Excepciones.CaracterInvalido;
import gestorAplicacion.paquete1.Administrador;
import gestorAplicacion.paquete1.Cliente;
import gestorAplicacion.paquete1.Instructor;
import gestorAplicacion.paquete1.Usuario;
import gestorAplicacion.paquete1.Vendedor;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import uiMain.menuConsola.MenuDeConsola;
import windows.FieldPanel;
/*
    * Esta clase retorna un Pane con la información para realizar el registro de un usuario.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
public class RegistrarUsuario extends FlowPane {

    public RegistrarUsuario() {
        Administrador admin = (Administrador) new MenuDeConsola().getSesion();
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "Seleccione",
                "Cliente",
                "Vendedor",
                "Instructor"
        );
        comboBox.setValue("Seleccione");
        this.getChildren().add(comboBox);
        this.getChildren().add(new Label());
        comboBox.setOnAction((event) -> {
            String opcion = (String) comboBox.getValue();
            if (opcion.equals("Cliente")) {
                Button registrarseEnviar = new Button("Registrar");

                String criterios[] = {"Cédula", "Nombre", "Contraseña", "Peso", "Estatura", "Edad", "Genero", "Telefono"};
                String valores[] = null;
                boolean estado[] = null;
                FieldPanel fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
                GridPane migrid = fieldPanel.getGrid();
                migrid.addColumn(1, registrarseEnviar);
                migrid.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                migrid.setPadding(new Insets(10, 10, 10, 10));
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
                            if (!admin.registrarUsuario(cliente)) {
                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                alerta.setContentText("Error al registrar usuario.");
                                alerta.show();
                            }else{
                                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                                alerta.setContentText("Registro exitoso.");
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
                });
                this.getChildren().set(1, migrid);
            } else {
                Button registrarseEnviar = new Button("Registrar");

                String criterios[] = {"Cédula", "Nombre", "Contraseña"};
                String valores[] = null;
                boolean estado[] = null;
                FieldPanel fieldPanel = new FieldPanel("Datos", criterios, "Valores", valores, estado);
                GridPane migrid = fieldPanel.getGrid();
                migrid.addColumn(1, registrarseEnviar);
                migrid.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                migrid.setPadding(new Insets(10, 10, 10, 10));
                /*
    * Este evento se encarga de registrar usuarios.
    * Autores: Juan Camilo Hoyos, Jean Carlo Herrera, Santiago López Gallego, Juan Camilo Muñoz
     */
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
                        Usuario usuario=null;
                        if (opcion.equals("Instructor")) {
                            usuario = new Instructor(textFieldList.get(1).getText(),textFieldList.get(0).getText(), textFieldList.get(2).getText());
                        }else if(opcion.equals("Vendedor")){
                            usuario = new Vendedor(textFieldList.get(1).getText(),textFieldList.get(0).getText(), textFieldList.get(2).getText());
                        }

                        if (!admin.registrarUsuario(usuario)) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setContentText("Error al registrar usuario.");
                            alerta.show();
                        }else{
                            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                            alerta.setContentText("Registro exitoso.");
                            alerta.show();
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
                });
                this.getChildren().set(1, migrid);
            }
        });

    }
}
