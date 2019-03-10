package stationservice.UIcomponate;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import stationservice.entity.DeclarationProduit;

public class ProduitDetailsCell extends GridPane {

    private ColumnConstraints columnConstraints;
    private ColumnConstraints columnConstraints0;
    private ColumnConstraints columnConstraints1;
    private ColumnConstraints columnConstraints2;
    private ColumnConstraints columnConstraints3;
    private ColumnConstraints columnConstraints4;
    private ColumnConstraints columnConstraints5;
    private RowConstraints rowConstraints;
    private Label id;
    private Label des;
    private Label ancien;
    private Label nouveau;
    private Label prix;
    private Label quantite;
    private Label total;
    
    private DeclarationProduit dp  ; 

    public ProduitDetailsCell(DeclarationProduit dp ) {
        
        this.dp = dp ; 

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        id = new Label();
        des = new Label();
        ancien = new Label();
        nouveau = new Label();
        prix = new Label();
        quantite = new Label();
        total = new Label();

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

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        id.setText(Integer.toString(this.dp.getIdproduit().getId()));
        id.setFont(new Font(16.0));

        GridPane.setColumnIndex(des, 1);
        des.setText(this.dp.getIdproduit().getDisignations());
        des.setFont(new Font(16.0));

        GridPane.setColumnIndex(ancien, 2);
        ancien.setText(Integer.toString(dp.getAncien()));
        ancien.setFont(new Font(16.0));

        GridPane.setColumnIndex(nouveau, 3);
        nouveau.setText(Integer.toString(dp.getNouveau()));
        nouveau.setFont(new Font(16.0));

        GridPane.setColumnIndex(prix, 4);
        prix.setText(Double.toString(dp.getPrix()));
        prix.setFont(new Font(16.0));

        GridPane.setColumnIndex(quantite, 5);
        quantite.setText(Integer.toString(dp.getQuantite()));
        quantite.setFont(new Font(16.0));

        GridPane.setColumnIndex(total, 6);
        total.setText(Double.toString(dp.getSomme()));
        total.setFont(new Font(16.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getColumnConstraints().add(columnConstraints3);
        getColumnConstraints().add(columnConstraints4);
        getColumnConstraints().add(columnConstraints5);
        getRowConstraints().add(rowConstraints);
        getChildren().add(id);
        getChildren().add(des);
        getChildren().add(ancien);
        getChildren().add(nouveau);
        getChildren().add(prix);
        getChildren().add(quantite);
        getChildren().add(total);

    }
}
