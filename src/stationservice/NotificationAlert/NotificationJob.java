
package stationservice.NotificationAlert;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import stationservice.UIcomponate.StageDialog;
import stationservice.UIcomponate.ViewURL;
import stationservice.model.ProduitModel;


public class NotificationJob  {
    private  Stage  stageOwner  ; 
    public NotificationJob() {
    }

    public NotificationJob(Stage stageOwner) {
        this.stageOwner = stageOwner;
    }
    
    
    public void startNotification() {
        Timer timer = new Timer("Notification Timer") ;
        timer.schedule(
                new TimerTask() {

            @Override
            public void run() {
               Platform.runLater(new Runnable() {
                   @Override
                   public void run() {
                      showNotification();
                   }
 
                } ) ;  
            }
        }, 0, 60000);
        
       
       
    }

    
    
    private void showNotification () {
        
        try {
            if (ProduitModel.getSuper().etatProduit()>1 || ProduitModel.getSp1().etatProduit()>1 
                    || ProduitModel.getSp2().etatProduit()>1 || ProduitModel.getGasoil().etatProduit()>1) {
                
            } 
            AnchorPane root = FXMLLoader.load(getClass().getResource(ViewURL.notification));
            StageDialog  dialog   = new StageDialog(this.stageOwner, root)  ; 
           
            if (!dialog.isShowing()) {
               dialog.showAndWait();   
            }   
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
}
