package stationservice.controler;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import stationservice.entity.User;
import stationservice.model.UserModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class AddUserController implements Initializable {

    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField confirm;
    @FXML
    private JFXComboBox<String> privilege;
    @FXML
    private JFXToggleButton active;

    private User userObj;
    private boolean usecase;
    @FXML
    private ImageView close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        privilege.getItems().add("Admin");
        privilege.getItems().add("Agent");

        this.usecase = true;
    }

    @FXML
    private void annuler_action(ActionEvent event) {
        Methode.getStage(event).close();
    }

    @FXML
    private void action_save(ActionEvent event) {
        if (usecase) {
            add_user();
        } else {
            update_user();
        }
        UserListeController.show_users();
    }

    private void add_user() {
        if (user.getText().isEmpty() || password.getText().isEmpty() || confirm.getText().isEmpty()) {
            Notification.errorNotification();
        } else {
            if (password.getText().equals(confirm.getText())) {
                if (UserModel.isexiste(user.getText())) {

                    Notification.fauxNotification();
                    System.err.println("user  deblicate ");
                } else {
                    user_save();
                }

            } else {
                Notification.error("confirmer mot de passe ");
            }

        }

    }

    private void user_save() {
        if (usecase) {
            userObj = new User();
            userObj.setDateajoute(Methode.DateFormat(new Date()));
        }
        userObj.setUsername(user.getText());
        userObj.setPassword(password.getText());
        userObj.setPrivilege(privilege.getSelectionModel().getSelectedItem().toString());
        userObj.setActive(active.isSelected());

        UserModel.save(userObj);

        Notification.Addnotification();
    }

    private void update_user() {
        if (user.getText().isEmpty() || password.getText().isEmpty()) {
            Notification.errorNotification();
        } else {
            if (password.getText() == null ? userObj.getPassword() == null : password.getText().equals(userObj.getPassword())) {
                user_save();
            } else {
                if (password.getText().equals(confirm.getText())) {

                    user_save();

                } else {
                    Notification.error("confirmer mot de passe ");
                }

            }
        }
    }

    public void init(User u) {
        this.userObj = u;
        System.out.println(u.toString());
        this.usecase = false;
        user.setText(userObj.getUsername());
        password.setText(userObj.getPassword());
        this.privilege.getSelectionModel().select(userObj.getPrivilege());
        this.active.setSelected(userObj.isActive());

    }

    @FXML
    private void close(KeyEvent event) {
    }

    @FXML
    private void closeAction(MouseEvent event) {
        Methode.getStageMouses(event).close();
    }
}
