package uiMain.Opciones.Cliente;

import gestorAplicacion.paquete1.Cliente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import windows.BodyArt;

public class Consultar_Peso_Ideal implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        FlowPane calcularPesoIdeal = new FlowPane();
                calcularPesoIdeal.setVgap(20);
                calcularPesoIdeal.setHgap(20);
                Label informacion = new Label("Digite su estatura");
                TextField peso = new TextField();
                Button enviarbtn = new Button("Enviar");
//                Button calcularPesoIdealbtn = new Button("Calcular peso ideal");
                TextArea resultadoPesoIdeal = new TextArea();
                calcularPesoIdeal.getChildren().addAll(informacion, peso, enviarbtn, resultadoPesoIdeal);
                BorderPane centro= new BodyArt().getCentro();
                centro.setCenter(calcularPesoIdeal);

       
    }
    
}
