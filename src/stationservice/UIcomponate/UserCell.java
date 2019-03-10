package stationservice.UIcomponate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import stationservice.controler.AddUserController;
import stationservice.entity.User;
import stationservice.model.UserModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class UserCell extends GridPane {

    private ColumnConstraints columnConstraints;
    private ColumnConstraints columnConstraints0;
    private ColumnConstraints columnConstraints1;
    private ColumnConstraints columnConstraints2;
    private ColumnConstraints columnConstraints3;
    private RowConstraints rowConstraints;
    private Text user;
    private Text date;
    private Text previlege;
    private Text active;
    private JFXButton button;

    private User userobj;
    private JFXPopup popup;

    public UserCell(User u) {

        this.userobj = u;
        this.popup = new JFXPopup();

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        user = new Text();
        date = new Text();
        previlege = new Text();
        active = new Text();
        button = new JFXButton();

        setPrefHeight(50.0);
        setPrefWidth(628.0);

        columnConstraints.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(143.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(142.0);

        columnConstraints0.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(182.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(150.0);

        columnConstraints1.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(180.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(116.0);

        columnConstraints2.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(172.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(128.0);

        columnConstraints3.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(120.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(75.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        user.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        user.setStrokeWidth(0.0);
        user.setText(userobj.getUsername());
        user.setFont(new Font("Arial Bold", 16.0));

        GridPane.setColumnIndex(date, 1);
        date.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        date.setStrokeWidth(0.0);
        date.setText(Methode.dateFormat(userobj.getDateajoute()));
        date.setFont(new Font("Arial Bold", 16.0));

        GridPane.setColumnIndex(previlege, 2);
        previlege.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        previlege.setStrokeWidth(0.0);
        previlege.setText(userobj.getPrivilege());
        previlege.setFont(new Font("Arial Bold", 16.0));

        GridPane.setColumnIndex(active, 3);
        active.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        active.setStrokeWidth(0.0);
        active.setText("" + userobj.isActive());
        active.setFont(new Font("Arial Bold", 16.0));

        GridPane.setColumnIndex(button, 4);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getColumnConstraints().add(columnConstraints3);
        getRowConstraints().add(rowConstraints);
        getChildren().add(user);
        getChildren().add(date);
        getChildren().add(previlege);
        getChildren().add(active);
        getChildren().add(button);

        intpopup();
        button.setOnMouseClicked((event) -> {
            popup.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, event.getX(), event.getY());
        });
    }

    public void intpopup() {
        JFXButton modifier = new JFXButton("Modifier");
        JFXButton supprimer = new JFXButton("Archiver");

        modifier.setPadding(new Insets(10));
        supprimer.setPadding(new Insets(10));
        VBox box = new VBox(modifier, supprimer);
        box.setStyle("-fx-background-color: #ffffff");

        popup.setContent(box);
        popup.setSource(button);

        modifier.setOnAction(event -> {
            showUpdate(event);

        });

        supprimer.setOnAction(event -> {
            Optional<ButtonType> result = Notification.deleteAlert().showAndWait();
            if (result.get() == ButtonType.OK) {
                UserModel.delete(userobj) ; 
            }
            popup.close();
        });

    }

    private void showUpdate(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(ViewURL.addUser));
            loader.load();
            
            AddUserController addUserController = loader.getController();
            addUserController.init(this.userobj);
            AnchorPane root = loader.getRoot();
            
            StageDialog dialog = new StageDialog(Methode.getStage(event), root);
            dialog.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        popup.close();
    }

}
