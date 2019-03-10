package stationservice.controler;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import stationservice.UIcomponate.declCell;
import stationservice.entity.Declaration;
import stationservice.model.DeclarationModel;

public class DeclarationListeController implements Initializable {

    @FXML
    private JFXListView<declCell> liste;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<declCell> list = new ArrayList<>();

        for (Declaration declaration : DeclarationModel.getList()) {
            declCell cell = new declCell(declaration);
            list.add(cell);
        }

        ObservableList<declCell> myObservableList = FXCollections.observableList(list);
        liste.setItems(myObservableList);
        liste.setExpanded(true);
    }

}
