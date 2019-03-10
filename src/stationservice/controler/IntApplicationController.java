
package stationservice.controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import stationservice.entity.Produit;
import stationservice.ressource.Methode;


public class IntApplicationController implements Initializable {

    @FXML
    private JFXTextField sup;
    @FXML
    private JFXTextField sp1;
    @FXML
    private JFXTextField sp2;
    @FXML
    private JFXTextField gazoil;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXButton save;
    @FXML
    private JFXTextField nomentr;
    @FXML
    private JFXTextField telephone;
    @FXML
    private JFXTextField adresse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Methode.setOnlyNumbre(sp1);
        Methode.setOnlyNumbre(sp2);
        Methode.setOnlyNumbre(sup);
        Methode.setOnlyNumbre(gazoil);
      
    }    

    @FXML
    private void docancel(ActionEvent event) {
         Methode.getStage(event).close();
    }

    @FXML
    private void dosave(ActionEvent event) {
       
    }
    
    public void save () {
        try {    
        } catch (Exception e) {
        }
        
        
    } 
    
    
    
    
    
    
}
