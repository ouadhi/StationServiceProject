package stationservice.UIcomponate;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import stationservice.entity.Produit;

public  class ProduitCell extends GridPane {

    private  ColumnConstraints columnConstraints;
    private  ColumnConstraints columnConstraints0;
    private  ColumnConstraints columnConstraints1;
    private  ColumnConstraints columnConstraints2;
    private  ColumnConstraints columnConstraints3;
    private  RowConstraints rowConstraints;
    private  Label des;
    private  Label label;
    private  Label prix;
    private  Label quant;
    private  Label min;
    
    
    private Produit  produit  ; 

    public ProduitCell(Produit  produit ) {
        
        this.produit =  produit ; 

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        des = new Label();
        label = new Label();
        prix = new Label();
        quant = new Label();
        min = new Label();

        setAlignment(javafx.geometry.Pos.CENTER);
        setPrefHeight(53.0);
        setPrefWidth(629.0);

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

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        des.setText(this.produit.getDisignations());
        des.setFont(new Font("Arial", 18.0));

        GridPane.setColumnIndex(label, 4);
        label.setText(Integer.toString(this.produit.getMax()));
        label.setFont(new Font("Arial", 18.0));

        GridPane.setColumnIndex(prix, 1);
        prix.setText(""+this.produit.getPrix());
        prix.setFont(new Font("Arial", 18.0));

        GridPane.setColumnIndex(quant, 2);
        quant.setText(""+this.produit.getQuantite());
        quant.setFont(new Font("Arial", 18.0));

        GridPane.setColumnIndex(min, 3);
        min.setText(""+this.produit.getMin());
        min.setFont(new Font("Arial", 18.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getColumnConstraints().add(columnConstraints3);
        getRowConstraints().add(rowConstraints);
        getChildren().add(des);
        getChildren().add(label);
        getChildren().add(prix);
        getChildren().add(quant);
        getChildren().add(min);

    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
    
}
