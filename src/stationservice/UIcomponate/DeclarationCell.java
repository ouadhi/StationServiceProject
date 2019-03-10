package stationservice.UIcomponate;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import stationservice.controler.DeclarationDetialsController;
import stationservice.entity.Declaration;
import stationservice.ressource.Methode;

public class DeclarationCell extends GridPane {

    ColumnConstraints columnConstraints;
    ColumnConstraints columnConstraints0;
    ColumnConstraints columnConstraints1;
    ColumnConstraints columnConstraints2;
    ColumnConstraints columnConstraints3;
    ColumnConstraints columnConstraints4;
    ColumnConstraints columnConstraints5;
    ColumnConstraints columnConstraints6;
    RowConstraints rowConstraints;
    Label id;
    Label pompiste;
    Label quantite;
    Label total;
    Label tac;
    Label espece;
    Label diff;
    JFXButton bttn;

    private Declaration declaration;

    public DeclarationCell(Declaration declaration) {

        this.declaration = declaration;

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        id = new Label();
        pompiste = new Label();
        quantite = new Label();
        total = new Label();
        tac = new Label();
        espece = new Label();
        diff = new Label();
        bttn = new JFXButton();

        setPrefHeight(44.0);
        setPrefWidth(804.0);

        columnConstraints.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        columnConstraints3.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(100.0);

        columnConstraints4.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        columnConstraints5.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(100.0);

        columnConstraints6.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        id.setText(Integer.toString(this.declaration.getId()));
        id.setFont(new Font(16.0));

        GridPane.setColumnIndex(pompiste, 1);
        pompiste.setText(this.declaration.getIdpompiste().getNom());
        pompiste.setFont(new Font(16.0));

        GridPane.setColumnIndex(quantite, 2);
        quantite.setText("quantite");
        quantite.setFont(new Font(16.0));

        GridPane.setColumnIndex(total, 3);
        total.setText(Double.toString(this.declaration.getTotal()));
        total.setFont(new Font(16.0));

        GridPane.setColumnIndex(tac, 4);
        tac.setText(Double.toString(this.declaration.getBons()));
        tac.setFont(new Font(16.0));

        GridPane.setColumnIndex(espece, 5);
        espece.setText(Double.toString(this.declaration.getBillets()));
        espece.setFont(new Font(16.0));

        GridPane.setColumnIndex(diff, 6);
        diff.setText("");
        diff.setFont(new Font(16.0));

        GridPane.setColumnIndex(bttn, 7);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getColumnConstraints().add(columnConstraints3);
        getColumnConstraints().add(columnConstraints4);
        getColumnConstraints().add(columnConstraints5);
        getColumnConstraints().add(columnConstraints6);
        getRowConstraints().add(rowConstraints);
        getChildren().add(id);
        getChildren().add(pompiste);
        getChildren().add(quantite);
        getChildren().add(total);
        getChildren().add(tac);
        getChildren().add(espece);
        getChildren().add(diff);
        getChildren().add(bttn);

        bttn.setOnAction((event) -> {
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

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

}
