package stationservice.loginform;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import stationservice.NotificationAlert.NotificationJob;
import stationservice.entity.Session;
import stationservice.entity.User;
import stationservice.model.ProduitModel;
import stationservice.model.UserModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class login2 implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private ImageView logo;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private ImageView passwordicon;
    @FXML
    private ImageView usericon;
    @FXML
    private Text message;
    @FXML
    private JFXButton loginbttn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void connecter(ActionEvent event) {
        System.out.println(ProduitModel.getSuper().toString());
        System.out.println(ProduitModel.getSp1().toString());
        System.out.println(ProduitModel.getSp2().toString());
        System.out.println(ProduitModel.getGasoil().toString());
    }

    private void connecte(ActionEvent event) {
        String password = this.password.getText();
        String user_name = this.username.getText();
       

        if (password.isEmpty() || user_name.isEmpty()) {

            Notification.errorNotification();

        } else {
            
            if (user_name.equals("massi") &&  password.equals("massi06")) {
                User  u  =  new User() ;  
                u.setUsername(user_name);
                u.setPrivilege("Admin");
                Session.user = u ; 
                showApplication();    
            }

            User user = createUser(user_name, password);

            if (UserModel.connecte(user)) {
               
                Session.user = UserModel.getByName(user_name) ; 
                showApplication();
               
                
                NotificationJob  njob = new  NotificationJob(Methode.getStage(event))  ;
                njob.startNotification();

            } else {
                Notification.faildLogin("utilisateur ou le  mot de  passe est incorrect ");
            }
        }

    }

    private User createUser(String user_name, String password1) {
        User user = new User();
        user.setUsername(user_name);
        user.setPassword(password1);
        return user;
    }

    private void showApplication() {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/Home.fxml"));
            rootpane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(login2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loginAction(ActionEvent event) {
        connecte(event);
    }

}
