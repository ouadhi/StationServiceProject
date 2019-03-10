package stationservice.controler;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stationservice.ressource.Methode;

public class LoginController implements Initializable {

    @FXML
    private JFXButton login_button;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField motpasse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void login(ActionEvent event) {
        String user = this.user.getText();
        String password = this.motpasse.getText();

        if (user.isEmpty() || password.isEmpty()) {
            System.out.println("empty");
        } else {

            if ("admin".equals(user) && "root".equals(password)) {
                try {
                    Stage current_stage = Methode.getStage(event);
                    Stage new_stage = new Stage();

                    Parent root = FXMLLoader.load(getClass().getResource("/stationservice/view/Home.fxml"));
                    Scene scene = new Scene(root);
                    new_stage.setScene(scene);
                    new_stage.show();
                    
                    current_stage.close();
                    
                    System.out.println("log");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                  System.out.println("not log");
            }

        }
    }

}
