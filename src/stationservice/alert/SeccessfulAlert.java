package stationservice.alert;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import stationservice.UIcomponate.StageDialog;
import stationservice.ressource.Methode;

public  class SeccessfulAlert extends AnchorPane {

    protected final JFXButton jFXButton;
    protected final Text title;
    protected final Text message;
    protected final ImageView imageView;

    public SeccessfulAlert(String message_text) {

        jFXButton = new JFXButton();
        title = new Text();
        message = new Text();
        imageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(286.0);
        setPrefWidth(296.0);
        setStyle("-fx-background-color: #ffffff;");

        jFXButton.setLayoutX(12.0);
        jFXButton.setLayoutY(225.0);
        jFXButton.setStyle("-fx-background-color: #35d0ba;");
        jFXButton.setFont(new Font("Arial", 24.0));

        title.setLayoutX(76.0);
        title.setLayoutY(102.0);
        title.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        title.setStrokeWidth(0.0);
        title.setText("Successful");
        title.setFont(new Font(28.0));

        message.setLayoutX(67.0);
        message.setLayoutY(168.0);
        message.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        message.setStrokeWidth(0.0);
        message.setText(message_text);
        message.setFont(new Font(19.0));

        imageView.setFitHeight(72.0);
        imageView.setFitWidth(69.0);
        imageView.setLayoutX(119.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/stationservice/imgs/success.png").toExternalForm()));

        getChildren().add(jFXButton);
        getChildren().add(title);
        getChildren().add(message);
        getChildren().add(imageView);
        
        jFXButton.setOnAction(e -> {
           Stage  stage = Methode.getStage(e) ; 
           stage.close();
    } );

    }
    
    
    
    
    public void showAlert  (Stage stage )  {
        StageDialog  dialog  = new StageDialog(stage, this) ; 
        dialog.showAndWait(); 
    }
}
