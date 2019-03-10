package stationservice.controler;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import stationservice.UIcomponate.ShowScene;
import stationservice.entity.Produit;
import stationservice.model.ProduitModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class GererProduitViewController implements Initializable {

    @FXML
    private Text desgnation;
    @FXML
    private JFXTextField quantite;
    @FXML
    private JFXTextField max;
    @FXML
    private JFXTextField min;
    @FXML
    private JFXTextField quntite_add;

    private Produit produit;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private ImageView close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void cancel_action(ActionEvent event) {
        Methode.getStage(event).close();
    }

    @FXML
    private void save_action(ActionEvent event) {
        float add_qu;
        if (this.quntite_add.getText().toString().isEmpty()) {
            add_qu = 0;
        } else {
            add_qu = Float.parseFloat(this.quntite_add.getText());
        }

        float new_quantite = add_qu + produit.getQuantite();

        if (new_quantite > produit.getMax()) {
               Notification.errorNotification();
        } else {
           produit.setQuantite(new_quantite);
            ProduitModel.save(produit)   ; 
            Notification.Addnotification();
            
            Stage stage =  Methode.getStage(event) ; 
            stage.close(); 
            
            new ShowScene().showEtatCarburant();  
        }

    }

    public void init(Produit produit) {

        this.produit = produit;
        this.desgnation.setText(this.produit.getDisignations());
        this.quantite.setText(Float.toString(this.produit.getQuantite()));
        this.max.setText(Integer.toString(this.produit.getMax()));
        this.min.setText(Integer.toString(this.produit.getMin()));

        Methode.setAllOnlyNumbresAnchor(anchorpane);

        quntite_add.setText("0");
    }

    @FXML
    private void add_action_pressed(KeyEvent event) {
      
    }

    @FXML
    private void add_action_released(KeyEvent event) {
       
    }

    @FXML
    private void add_action_typed(KeyEvent event) {
       
    }

    private void add_carburant() {
        
        if (quntite_add.getText().toString().equals("")) {
            quntite_add.setText("0");
            float quan = 0 + Float.parseFloat(quantite.getText());
            quantite.setText(Float.toString(quan));
        } else {
            float quan = Float.parseFloat(quntite_add.getText()) + Float.parseFloat(quantite.getText());
            quantite.setText(Float.toString(quan));
        }
    }

    @FXML
    private void closeAction(MouseEvent event) {
        Methode.getStageMouses(event).close();
        new  ShowScene().showEtatCarburant();
        
    }

}
