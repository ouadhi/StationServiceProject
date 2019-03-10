package stationservice.controler;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.Instant;
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
import stationservice.UIcomponate.PompisteCell;
import stationservice.entity.Pompiste;
import stationservice.model.PompisteModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class PompisteController implements Initializable {

    @FXML
    private JFXListView<PompisteCell> liste;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField lieu;
    @FXML
    private JFXTextField telephone;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXDatePicker datenaissance;

    private Pompiste pompiste = null ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Methode.setOnlyInteger(telephone, 10);
        set_liste_pompiste();
    }

    @FXML
    private void select_action(MouseEvent event) {
       
        pompiste = liste.getSelectionModel().getSelectedItem().getPompiste();
        nom.setText(pompiste.getNom());
        prenom.setText(pompiste.getPrenom());
        lieu.setText(pompiste.getLieunais());
        adresse.setText(pompiste.getAdresse());
        datenaissance.setValue(convertToLocalDateViaInstant(pompiste.getDatenes()));
        telephone.setText(pompiste.getTelephone()); 
    }

    @FXML
    private void nouveau_action(ActionEvent event) {
        clearText();
        this.pompiste  =   null  ; 
    }

    @FXML
    private void save_action(ActionEvent event) {
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String leiu = this.lieu.getText();
        String telephone = this.telephone.getText();
        String adresse = this.adresse.getText();
        Date date_naissance = Date.from(datenaissance.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        if (nom.isEmpty() || prenom.isEmpty() || leiu.isEmpty() || telephone.isEmpty() || adresse.isEmpty()) {
            Notification.champVideNotification();
        } else {
            if (pompiste  == null ) {
                pompiste = new Pompiste();
            }
            pompiste.setNom(nom);
            pompiste.setPrenom(prenom);
            pompiste.setLieunais(leiu);
            pompiste.setTelephone(telephone);
            pompiste.setAdresse(adresse);
            pompiste.setDatenes(date_naissance);
            pompiste.setDateajoutpompiste(Methode.DateFormat(new Date()));

            PompisteModel.save(pompiste);
            Notification.Addnotification();
            set_liste_pompiste();
        }
    }

    @FXML
    private void supp_action(ActionEvent event) {
        if (pompiste ==  null) {
            Notification.errorNotification();
        }else{
            PompisteModel.delete(pompiste) ; 
         }
    }

    private void set_liste_pompiste() {
        List<PompisteCell> list = new ArrayList<>();
        for (Pompiste pompiste : PompisteModel.getList()) {
            PompisteCell cell = new PompisteCell(pompiste);
            list.add(cell);
        }
        ObservableList<PompisteCell> myObservableList = FXCollections.observableList(list);
        this.liste.getItems().clear();
        this.liste.setItems(myObservableList);
        this.liste.setExpanded(true);
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private void clearText() {
        nom.setText("");
        prenom.setText("");
        lieu.setText("");
        telephone.setText("");
        adresse.setText("");
    }
}
