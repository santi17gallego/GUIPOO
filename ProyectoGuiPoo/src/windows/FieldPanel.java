package windows;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {

    private GridPane grid = new GridPane();

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
            boolean[] habilitado) {
        
        grid.addColumn(0, new Label(tituloCriterios));
        grid.addColumn(1, new Label(tituloValores));
        for (int i = 0; i < criterios.length; i++) {
            grid.addColumn(0, new Label(criterios[i]));
            TextField textField = new TextField(valores[i]);
            if (habilitado[i] == false) {
                textField.setEditable(false);
            }
            grid.addColumn(1, textField);
        }
//        for (String criterio : criterios){
//            grid.addColumn(0, new Label(criterio));
//        }
//        for (String valore : valores) {
//            grid.addColumn(1, new TextField(valore));
//        }

    }

    public GridPane getGrid() {
        return grid;
    }
}
