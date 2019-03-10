
package stationservice.controler;

import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import stationservice.UIcomponate.StageDialog;
import stationservice.UIcomponate.UserCell;
import stationservice.entity.User;
import stationservice.model.UserModel;
import stationservice.ressource.Methode;


public class UserListeController implements Initializable {

    @FXML
    private JFXListView<UserCell> listeUsers;
    public static JFXListView<UserCell> staticlisteUsers ; 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      showListeUsers();
    }    

    @FXML
    private void nouveau_action(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/AddUserView.fxml"));
            StageDialog   dialog  =  new StageDialog(Methode.getStage(event), root) ; 
            dialog.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   private void  showListeUsers ()  {
        List<UserCell> list = new ArrayList<>();
        for (User user : UserModel.getList()) {
           UserCell cell = new UserCell(user)  ; 
           list.add(cell) ;
       }
        ObservableList<UserCell> myObservableList = FXCollections.observableList(list);
        listeUsers.setItems(myObservableList);
        listeUsers.setExpanded(true);
   } 
   
   
   public static  void  show_users  () {
       List<UserCell> list = new ArrayList<>();
        for (User user : UserModel.getList()) {
           UserCell cell = new UserCell(user)  ; 
           list.add(cell) ;
       }
        ObservableList<UserCell> myObservableList = FXCollections.observableList(list);
        staticlisteUsers.setItems(myObservableList);
        staticlisteUsers.setExpanded(true);
   } 

    @FXML
    private void closeAction(MouseEvent event) {
        Stage stage =  Methode.getStageMouses(event)  ;  
        stage.close();
    }
    
}
