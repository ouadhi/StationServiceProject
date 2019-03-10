package stationservice.controler;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import stationservice.UIcomponate.ProduitCell;
import stationservice.entity.Produit;
import stationservice.model.ProduitModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class ProduitController implements Initializable {

    @FXML
    private JFXTextField desgnation;
    @FXML
    private JFXListView<ProduitCell> liste;
    @FXML
    private JFXTextField min;

    Produit produit = null;
    @FXML
    private JFXTextField mix;
    @FXML
    private JFXTextField compteur;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField quantite;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Methode.setOnlyInteger(min, 5);
        show_liste();
    }

    @FXML
    private void select_action(MouseEvent event) {
        this.produit = liste.getSelectionModel().getSelectedItem().getProduit();
        
        desgnation.setText(this.produit.getDisignations());
        prix.setText(""+this.produit.getPrix());
        quantite.setText(""+this.produit.getQuantite());
        min.setText(""+this.produit.getMin());
        mix.setText(""+this.produit.getMax());
        compteur.setText(""+this.produit.getCompteur());
    }

    @FXML
    private void nouveau_action(ActionEvent event) {

        desgnation.setText("");
        quantite.setText("");
        min.setText("");
        compteur.setText("");
        mix.setText("");
        prix.setText("");
    }

    @FXML
    private void save_action(ActionEvent event) {

        String desg = desgnation.getText();
        int min_val = Integer.parseInt(min.getText());
        int max_val =  Integer.parseInt(mix.getText())  ; 
        float quantit_val =  Float.parseFloat(quantite.getText())  ; 
        int compt  =  Integer.parseInt(compteur.getText());
        float prix_val  =  Float.parseFloat(prix.getText())  ;

        if (desg.isEmpty() || min.getText().isEmpty() || mix.getText().isEmpty()  || quantite.getText().isEmpty() ||  compteur.getText().isEmpty()||  prix.getText().isEmpty()) {
            Notification.champVideNotification();
        } else {
            
            produit.setDisignations(desg);
            produit.setMin(min_val);
            produit.setMax(max_val);
            produit.setQuantite(quantit_val);
            produit.setCompteur(compt);
            produit.setPrix(prix_val);

            ProduitModel.save(produit);
            Notification.Addnotification();
            show_liste();
        }
    }

    @FXML
    private void supp_action(ActionEvent event) {
        if (this.produit == null) {
            Notification.errorNotification();
        } else {
            ProduitModel.delete(this.produit);
            Notification.Deletenotification();
            desgnation.setText("");
            min.setText("");
            show_liste();
        }
    }

    public void show_liste() {
        List<ProduitCell> list = new ArrayList<>();

        for (Produit produit : ProduitModel.getList()) {
            ProduitCell cell = new ProduitCell(produit) ; 
            list.add(cell);
        }

        ObservableList<ProduitCell> myObservableList = FXCollections.observableList(list);
        liste.setItems(myObservableList);
        liste.setExpanded(true);

    }

}
