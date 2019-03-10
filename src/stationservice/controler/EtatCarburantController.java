package stationservice.controler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import stationservice.UIcomponate.StageDialog;
import stationservice.entity.Produit;
import stationservice.model.ProduitModel;
import stationservice.ressource.Colors;
import stationservice.ressource.Methode;

public class EtatCarburantController implements Initializable {

    @FXML
    private GridPane super_level;
    @FXML
    private GridPane sp1_level;
    @FXML
    private GridPane sp2_level;
    @FXML
    private GridPane gasoil_level;
    @FXML
    private Text super_quantie;
    @FXML
    private Text sp1_quantite;
    @FXML
    private Text sp2_quantite;
    @FXML
    private Text gasoil_quantite;
    @FXML
    private HBox conteur_super;
    @FXML
    private HBox conteur_sp1;
    @FXML
    private HBox conteur_sp2;
    @FXML
    private HBox conteur_gasoil;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setLevel(super_level, Colors.super_color, ProduitModel.getSuper());
        this.setLevel(sp1_level, Colors.sp1_color, ProduitModel.getSp1());
        this.setLevel(sp2_level, Colors.sp2_color, ProduitModel.getSp2());
        this.setLevel(gasoil_level, Colors.gasoil_color, ProduitModel.getGasoil());

        super_quantie.setText(Float.toString(ProduitModel.getSuper().getQuantite()));
        sp1_quantite.setText(Float.toString(ProduitModel.getSp1().getQuantite()));
        sp2_quantite.setText(Float.toString(ProduitModel.getSp2().getQuantite()));
        gasoil_quantite.setText(Float.toString(ProduitModel.getGasoil().getQuantite()));

        setConteur(this.conteur_super, ProduitModel.getSuper().getCompteur());
        setConteur(this.conteur_sp1, ProduitModel.getSp1().getCompteur());
        setConteur(this.conteur_sp2, ProduitModel.getSp2().getCompteur());
        setConteur(this.conteur_gasoil, ProduitModel.getGasoil().getCompteur());

    }

    private Pane pane(String color) {
        Pane pane = new Pane();

        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);
        pane.setStyle("-fx-background-color: " + color + ";");

        return pane;

    }

    private void setLevel(GridPane gridPane, String color, Produit produit) {
        int level = calcule_level(produit, gridPane.getRowConstraints().size());
        for (int i = gridPane.getRowConstraints().size() - 1; i >= gridPane.getRowConstraints().size() - level; --i) {
            gridPane.add(pane(color), 0, i);
        }
    }

    private int calcule_level(Produit produit, int max_level) {
        int max_quantite = produit.getMax();
        float quantite = produit.getQuantite();
        int level = (int) ((quantite * max_level) / max_quantite);

        return level;
    }

    @FXML
    private void super_gerer(ActionEvent event) {
        showGererStage(event, ProduitModel.getSuper());

    }

    @FXML
    private void sp1_gerer(ActionEvent event) {
        showGererStage(event, ProduitModel.getSp1());
    }

    @FXML
    private void sp2_gerer(ActionEvent event) {
        showGererStage(event, ProduitModel.getSp2());
    }

    @FXML
    private void gazoil_gerer(ActionEvent event) {
        showGererStage(event, ProduitModel.getGasoil());
    }

    private void showGererStage(ActionEvent event, Produit produit) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/stationservice/view/GererProduitView.fxml"));
            loader.load();

            GererProduitViewController controller = loader.getController();
            controller.init(produit);

            AnchorPane root = loader.getRoot();

            StageDialog dialog = new StageDialog(Methode.getStage(event), root);
            dialog.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void setConteur(HBox bow, int val) {
        ArrayList<Node> listeNode = Methode.getAllNodes(bow);
        char[] chars = integerToArray(val, 8);
        int i = 0;
        for (int j = listeNode.size() - 1; j >= 0; --j) {
            Node node = listeNode.get(j);
            if (node instanceof Label) {
                Label label = (Label) node;
                label.setText("" + chars[j]);

            }
        }
    }

    private char[] integerToArray(int nb, int length) {
        char[] chars1 = ("" + nb).toCharArray();
        char[] chars2 = new char[length];

        for (int i = 0; i < 8; i++) {
            chars2[i] = '0';
        }
        int j = 0;
        for (int i = chars2.length - chars1.length; i < chars2.length; i++) {
            chars2[i] = chars1[j];
            j++;
        }
        return chars2;
    }

}
