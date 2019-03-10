package stationservice;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import stationservice.UIcomponate.StageDialog;
import stationservice.UIcomponate.ViewURL;
import stationservice.model.BonsModel;
import stationservice.model.ProduitModel;
import stationservice.ressource.SessionsGenerator;

public class StationService extends Application {

    @Override
    public void start(Stage stage) {
        try {
       
            SessionsGenerator FactoryObject = new SessionsGenerator();

            /*
             /  test si les produit sont  cree ou  non 
             */
            ProduitModel.testProduit();
            
            
            /*
            Bons test
            */
            BonsModel.testBons();

            Parent root = FXMLLoader.load(getClass().getResource("/stationservice/loginform/FXMLDocument.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource(ViewURL.notification));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Image icon  =  new Image(getClass().getResourceAsStream("/stationservice/imgs/green.png")) ;
            stage.getIcons().add(icon);
            stage.setTitle("Station Service APP");
            stage.show();
            
            stage.setOnCloseRequest(e -> {
                 System.out.println("exit application ");
                 System.exit(0); 
            });

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
