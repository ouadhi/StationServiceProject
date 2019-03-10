
package stationservice.UIcomponate;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import stationservice.controler.HomeController;


public class ShowScene {
    
    
    public void showEtatCarburant () {
         try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/EtatCarburant.fxml"));
            HomeController.staticMainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
