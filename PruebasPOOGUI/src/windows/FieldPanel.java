package windows;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {

    private GridPane grid = new GridPane();

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
            boolean[] habilitado) {
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addColumn(0, new Label(tituloCriterios));
        grid.addColumn(1, new Label(tituloValores));
        for (int i = 0; i < criterios.length; i++) {
            grid.addColumn(0, new Label(criterios[i]));
            TextField textField = (valores == null ? new TextField() : new TextField(valores[i]));
            textField.setId(criterios[i]);
            if (habilitado != null) {
                if (habilitado[i] == false) {
                    textField.setEditable(false);
                }
            }
            grid.addColumn(1, textField);
        }

    }

    public GridPane getGrid() {
        return grid;
    }
}