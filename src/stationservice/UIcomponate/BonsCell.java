package stationservice.UIcomponate;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import stationservice.entity.Bons;
import stationservice.ressource.Methode;

public  class BonsCell extends GridPane {

     ColumnConstraints columnConstraints;
     ColumnConstraints columnConstraints0;
     ColumnConstraints columnConstraints1;
     RowConstraints rowConstraints;
     Label designation;
     Label valeur;
     Label date;
     Bons bons   ; 
     
    public BonsCell(Bons bons ) {
        this.bons  = bons  ; 

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        designation = new Label();
        valeur = new Label();
        date = new Label();

        setPrefHeight(45.0);
        setPrefWidth(445.0);

        columnConstraints.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(160.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(125.0);

        columnConstraints0.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(198.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(138.0);

        columnConstraints1.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(189.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(182.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        designation.setText(bons.getDesignation());
        designation.setFont(new Font("Arial", 16.0));

        GridPane.setColumnIndex(valeur, 1);
        valeur.setText(Double.toString(bons.getVal()));
        valeur.setFont(new Font("Arial", 16.0));

        GridPane.setColumnIndex(date, 2);
        date.setText(Methode.dateFormat(bons.getDateajoutbons()));
        date.setFont(new Font("Arial", 16.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getChildren().add(designation);
        getChildren().add(valeur);
        getChildren().add(date);

    }

    public Bons getBons() {
        return bons;
    }

    public void setBons(Bons bons) {
        this.bons = bons;
    }
    
   
}
