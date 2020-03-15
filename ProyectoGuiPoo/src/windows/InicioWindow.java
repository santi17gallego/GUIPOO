package windows;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author Juan Camilo Hoyos
 */
public class InicioWindow extends Application {

    

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane miborderpane =new BorderPane();
        miborderpane.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        primaryStage.setTitle("");
        
        miborderpane.setPadding(new Insets(10,10,10,10));
        Button salirbtn = new Button("salir");
        Button descripcionbtn=new Button("Descripcion");
        GridPane migridpane=new GridPane();
        
        migridpane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        migridpane.setPadding(new Insets(5,5,5,5));
        
        Label nombrelb=new Label("BodyArt");
        
        migridpane.add(nombrelb,1,1);
        migridpane.add(salirbtn,5,1);
        migridpane.add(descripcionbtn,6,1);
        migridpane.setVgap(3);
        migridpane.setHgap(5);
        
        miborderpane.setTop(migridpane); //metimos primer grid a mi
        //hasta aca bien
        
        //MIBORDERPANER
        
        BorderPane organizador=new BorderPane();
        miborderpane.setCenter(organizador);
        
        
        GridPane migridpane2=new GridPane();  //segundo panel creado izquierdo.
        migridpane2.setPadding(new Insets(10,10,10,10));
        GridPane migridpane3=new GridPane(); //segundo panel creado derecho.
        migridpane3.setPadding(new Insets(10,10,10,10));
        migridpane3.setMaxWidth(Double.MAX_VALUE);
        organizador.setLeft(migridpane2);
        organizador.setRight(migridpane3);
        organizador.setCenter(null);
        
        migridpane3.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        migridpane2.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        
        //MIGRIDPANE2
        BorderPane miborderpane2_1=new BorderPane(); //border de saludo.
        GridPane migridpane2_2=new GridPane();
        migridpane2.add(miborderpane2_1,0,0); //anidamos 
        migridpane2.add(migridpane2_2,0,1); //anidamos
        migridpane2.setVgap(5);
        migridpane2.setHgap(5);
        
        //borderpane2_1
        
        Label saludobl=new Label("Bienvenidos al gimnasio Body Art");
        miborderpane2_1.setCenter(saludobl);
        
        miborderpane2_1.setPadding(new Insets(10,10,10,10));
        
        //Gridpane2_2
        TextField usuariotf=new TextField();
        TextField contraseñatf=new TextField();
        Button ingresarbt=new Button("Ingresar");
        Button registrarsebt=new Button("Registrarse");
        
        migridpane2_2.add(usuariotf,0,0);
        migridpane2_2.add(contraseñatf,1,0);
        migridpane2_2.add(ingresarbt,0,1);
        migridpane2_2.add(registrarsebt,0,3);
        
        migridpane2_2.setHgap(3);
        migridpane2_2.setVgap(3);
        
        //colocar lineas chimbas
        migridpane2_2.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        migridpane2_2.setPadding(new Insets(10,10,10,10));
        
        //GRIDPANE3
        
        BorderPane miborderpane3_1=new BorderPane();
        BorderPane miborderpane3_2=new BorderPane();
        
        
        
        migridpane3.add(miborderpane3_1,0,0);
        migridpane3.add(miborderpane3_2,0,1);
        miborderpane3_1.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        miborderpane3_2.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        miborderpane3_1.setCenter(new Label("Aqui va una imagen"));
        miborderpane3_1.setPadding(new Insets(10,10,10,10));
        miborderpane3_2.setPadding(new Insets(10,10,10,10));
      //  
        Scene primeraescena = new Scene(miborderpane, 550, 400);
        primaryStage.setScene(primeraescena);
        primaryStage.show();
        
        

    }
    public static void main(String [] args){
        launch(args);
    }
    
}   
