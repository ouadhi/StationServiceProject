package stationservice.UIcomponate;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import stationservice.controler.DeclarationDetialsController;
import stationservice.entity.Declaration;
import stationservice.ressource.Methode;

public class declCell extends GridPane {

    private ColumnConstraints columnConstraints;
    private ColumnConstraints columnConstraints0;
    private ColumnConstraints columnConstraints1;
    private ColumnConstraints columnConstraints2;
    private ColumnConstraints columnConstraints3;
    private ColumnConstraints columnConstraints4;
    private ColumnConstraints columnConstraints5;
    private ColumnConstraints columnConstraints6;
    private ColumnConstraints columnConstraints7;
    private ColumnConstraints columnConstraints8;
    private RowConstraints rowConstraints;
    private Text text;
    private Text text0;
    private Text text1;
    private Text text2;
    private Text text3;
    private Text text4;
    private Text text5;
    private Text text6;
    private Text text7;
    private JFXButton jFXButton;

    private Declaration declaration;

    public declCell(Declaration declaration) {
        this.declaration = declaration;

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        text7 = new Text();
        jFXButton = new JFXButton();

        setPrefHeight(40.0);
        setPrefWidth(1073.0);

        columnConstraints.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(104.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(75.0);

        columnConstraints0.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(141.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(141.0);

        columnConstraints1.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(131.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(131.0);

        columnConstraints2.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(111.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(84.0);

        columnConstraints3.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(100.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(97.0);

        columnConstraints4.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(113.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(113.0);

        columnConstraints5.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(123.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(114.0);

        columnConstraints6.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(130.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(112.0);

        columnConstraints7.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(135.0);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(117.0);

        columnConstraints8.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMaxWidth(102.0);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(74.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("" + this.declaration.getId());
        text.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text0, 1);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText(this.declaration.getIdpompiste().getNom());
        text0.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text1, 2);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText(Methode.dateFormat(this.declaration.getDate()));
        text1.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text2, 3);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText(this.declaration.getDebut_job());
        text2.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text3, 4);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText(this.declaration.getFin_job());
        text3.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text4, 6);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("" + this.declaration.getBons());
        text4.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text5, 5);
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("" + this.declaration.getTotal());
        text5.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text6, 7);
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("" + this.declaration.getBillets());
        text6.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(text7, 8);
        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("" + this.declaration.getAvance());
        text7.setFont(new Font("Arial Bold", 17.0));

        GridPane.setColumnIndex(jFXButton, 9);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getColumnConstraints().add(columnConstraints3);
        getColumnConstraints().add(columnConstraints4);
        getColumnConstraints().add(columnConstraints5);
        getColumnConstraints().add(columnConstraints6);
        getColumnConstraints().add(columnConstraints7);
        getColumnConstraints().add(columnConstraints8);
        getRowConstraints().add(rowConstraints);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(text3);
        getChildren().add(text4);
        getChildren().add(text5);
        getChildren().add(text6);
        getChildren().add(text7);
        getChildren().add(jFXButton);

        jFXButton.setOnAction((event) -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/stationservice/view/DeclarationDetials.fxml"));
                loader.load();

                DeclarationDetialsController controller = loader.getController();
                controller.init(this.declaration);

                AnchorPane root = loader.getRoot();

                StageDialog dialog = new StageDialog(Methode.getStage(event), root);
                dialog.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

    }
}
