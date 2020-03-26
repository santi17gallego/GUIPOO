package windows;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {

    private GridPane grid = new GridPane();
    private String[] criterios;
    private String[] valores;
    
    private ArrayList<TextField> textFieldList= new ArrayList<TextField>();

    public ArrayList<TextField> getTextFieldList() {
        return textFieldList;
    }

    public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
            boolean[] habilitado) {
        this.criterios=criterios;
        this.valores=valores;
        
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
            textFieldList.add(textField);
            grid.addColumn(1, textField);
        }

    }
    

    public GridPane getGrid() {
        return grid;
    }

    public String getValue(String criterio) {
        String valor="";
        for (int i = 0; i < criterios.length; i++) {
            if(criterio.equals(criterios[i])){
                valor=valores[i];
                break;
            }
        }
        return valor;
    }
    public String getValue(final int row, final int column) {
        String result = null;
        ObservableList<Node> childrens = grid.getChildren();
        for (Node node : childrens) {
            if (grid.getRowIndex(node) == row && grid.getColumnIndex(node) == column) {
                result = ((TextField)node).getText();
                break;
            }
        }
        return result;
    }
    
}
