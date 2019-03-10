package stationservice.UIcomponate;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import stationservice.entity.Decbons;

public  class BonsDetailsCell extends GridPane {

    private ColumnConstraints columnConstraints;
    private ColumnConstraints columnConstraints0;
    private ColumnConstraints columnConstraints1;
    private ColumnConstraints columnConstraints2;
    private RowConstraints rowConstraints;
    private Label id;
    private Label valeur;
    private Label nombre;
    private Label somme;
    
    private Decbons  decbons  ; 
    public BonsDetailsCell(Decbons  decbons ) {
        
        this.decbons = decbons ;  

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        id = new Label();
        valeur = new Label(); 
        nombre = new Label();
        somme = new Label();

        columnConstraints.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(96.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(77.0);

        columnConstraints0.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(128.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(106.0);

        columnConstraints1.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(118.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(109.0);

        columnConstraints2.setHalignment(javafx.geometry.HPos.CENTER);
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(108.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(108.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        id.setText(Integer.toString(this.decbons.getIdbons().getId()));
        id.setFont(new Font(16.0));

        GridPane.setColumnIndex(valeur, 1);
        valeur.setText(Double.toString(this.decbons.getIdbons().getVal()));
        valeur.setFont(new Font(16.0));

        GridPane.setColumnIndex(nombre, 2);
        nombre.setText(Integer.toString(this.decbons.getNbons()));
        nombre.setFont(new Font(16.0));

        GridPane.setColumnIndex(somme, 3);
        somme.setText(Double.toString(this.decbons.getTotal()));
        somme.setFont(new Font(16.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getRowConstraints().add(rowConstraints);
        getChildren().add(id);
        getChildren().add(valeur);
        getChildren().add(nombre);
        getChildren().add(somme);

    }
}
