
package stationservice.controler;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import stationservice.entity.User;
import stationservice.model.UserModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class ProfileController implements Initializable {
    private  User  user ;  
    @FXML
    private JFXTextField userText;
    @FXML
    private JFXPasswordField passworText;
    @FXML
    private JFXPasswordField newPassworText;
    @FXML
    private JFXPasswordField ConfirmeMotDePasse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    } 
    
    public void init(User  user) {
        this.user = user ; 
        
        userText.setText(user.getUsername());
        
    }

    @FXML
    private void canceAction(ActionEvent event) {
         Methode.getStage(event).close();
    }

    @FXML
    private void saveAction(ActionEvent event) {
        doSave(event);
    }
    
    
    private void  doSave(ActionEvent event)  {
        // if  password  is empty  close the stage with no Update 
        if (passworText.getText().equals("")) {
            Methode.getStage(event).close();
        } else {
            // password teyped by user equals at the  password  save in database  
            if (passworText.getText().equals(user.getPassword())) {
                // new  password  equals at confirme  password  
                 if (newPassworText.getText().equals(ConfirmeMotDePasse.getText())) {
                    this.user.setPassword(newPassworText.getText());
                     UserModel.save(user) ;
                     Notification.Updatenotification();
                      Methode.getStage(event).close();
                }else{
                   Notification.error("Confirmer   le nouveau  mot de passe");
                 }
            }else{
                Notification.error("Verifier  le  Mot De passe");
            }
                
        }
    }
    
}
