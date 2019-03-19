package stationservice.controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import stationservice.UIcomponate.StageDialog;
import stationservice.entity.Session;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class HomeController implements Initializable {

    @FXML
    private JFXButton home_bttn;
    @FXML
    private JFXButton declaration_bttn;
    @FXML
    private JFXButton pompiste_bttn;
    @FXML
    private JFXButton produit_bttn;
    @FXML
    private JFXButton bon_bttn;
    @FXML
    private AnchorPane mainPane;
    public static AnchorPane staticMainPane;

    @FXML
    private Text user_txt;
    @FXML
    private JFXButton user;
    private JFXPopup popup;
    @FXML
    private ImageView more;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user_txt.setText(Session.user.getUsername());
        show_home();
        staticMainPane = mainPane;
        showAdminOrUser();
        popup = new JFXPopup();
        intpopup();
    }

    @FXML
    private void homeAction(ActionEvent event) {
        show_home();
    }

    @FXML
    private void declarationAction(ActionEvent event) {
        showDeclaration();
    }

    @FXML
    private void pompisteAction(ActionEvent event) {
        show_pompiste();
    }

    @FXML
    private void produitAction(ActionEvent event) {
        show_produit();
    }

    @FXML
    private void bonAction(ActionEvent event) {
        show_bons();
    }

    private void show_home() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/EtatCarburant.fxml"));
            mainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showDeclaration() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/AddDeclaration.fxml"));
            mainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void show_pompiste() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/Pompiste.fxml"));
            mainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void show_produit() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/Produit.fxml"));
            mainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void show_bons() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/Bons.fxml"));
            mainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void userButton(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/UserListeView.fxml"));
            Stage parrentStaeg = Methode.getStage(event);
            StageDialog dialog = new StageDialog(parrentStaeg, root);
            dialog.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showAdminOrUser() {

        if (Session.user.getPrivilege().equals("Admin")) {
            this.user.setVisible(true);
            this.bon_bttn.setVisible(true);
            this.produit_bttn.setVisible(true);

        } else {
            this.user.setVisible(false);
            this.bon_bttn.setVisible(false);
            this.produit_bttn.setVisible(false);
        }
    }


    public void intpopup() {
        JFXButton profileBttn = new JFXButton("Profile");
        JFXButton deconnecterBttn = new JFXButton("Deconnecter");
        profileBttn.setPadding(new Insets(10));
        deconnecterBttn.setPadding(new Insets(10));
        VBox box = new VBox(profileBttn, deconnecterBttn);
        box.setStyle("-fx-background-color: #ffffff");
        popup.setContent(box);
        popup.setSource(more);

        profileBttn.setOnAction(event -> {
          try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/stationservice/view/ProfileView.fxml"));
				loader.load();
                                
				ProfileController profileController = loader.getController(); 
                                profileController.init(Session.user);
                                
				AnchorPane root = loader.getRoot();
            
				StageDialog dialog = new StageDialog(Methode.getStage(event), root);
				dialog.show();
			} catch (Exception e ) {
				          System.out.println(e.getMessage());
			}
            popup.close();
        });
        
        deconnecterBttn.setOnAction(event -> {
            Optional<ButtonType> result = Notification.deleteAlert().showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
            popup.close();
        });
    }

    @FXML
    private void moreaction(MouseEvent event) {
        
       popup.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, event.getX(), event.getY());
    }

}
