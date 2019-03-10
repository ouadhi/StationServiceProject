package stationservice.view;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import stationservice.UIcomponate.BonsCell;
import stationservice.entity.Bons;
import stationservice.model.BonsModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class BonsController implements Initializable {

    @FXML
    private JFXListView<BonsCell> liste;
    @FXML
    private JFXTextField desg;
    @FXML
    private JFXTextField valeur;
    @FXML
    private JFXDatePicker dateajoute;
    
    private Bons  bons  ; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateajoute.setValue(LocalDate.now());
        Methode.setOnlyDouble(valeur, 5);

        showListe();

    }

    private void showListe() {
        List<BonsCell> list = new ArrayList<>();
        for (Bons bons : BonsModel.getList()) {
            BonsCell cell = new BonsCell(bons);
            list.add(cell);
        }
        ObservableList<BonsCell> myObservableList = FXCollections.observableList(list);
        this.liste.setItems(myObservableList);
        this.liste.setExpanded(true);
    }

    @FXML
    private void nouveu_action(ActionEvent event) {
        desg.setText("");
        valeur.setText("");
    }

    @FXML
    private void save_action(ActionEvent event) {
        String desg = this.desg.getText();
        String val = this.valeur.getText();
        Date dateAjout = Date.from(dateajoute.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (desg.isEmpty() || val.isEmpty()) {
            Notification.champVideNotification();
        } else {
            bons.setDateajoutbons(dateAjout);
            bons.setDesignation(desg);
            bons.setVal(Double.parseDouble(val));
            BonsModel.save(bons);
            Notification.Addnotification();
            showListe();
        }
    }

    @FXML
    private void supp_action(ActionEvent event) {
    }

    @FXML
    private void listeClickevenet(MouseEvent event) {
        this.bons  = liste.getSelectionModel().getSelectedItem().getBons()  ; 
        valeur.setText(Double.toString(bons.getVal()));
        desg.setText(bons.getDesignation());
        dateajoute.setValue(convertToLocalDateViaInstant(bons.getDateajoutbons()));
    }
    
    
    private  LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}

}
