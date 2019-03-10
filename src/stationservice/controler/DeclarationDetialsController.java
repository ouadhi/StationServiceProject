package stationservice.controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import stationservice.UIcomponate.BonsDetailsCell;
import stationservice.UIcomponate.ProduitDetailsCell;
import stationservice.entity.Decbons;
import stationservice.entity.Declaration;
import stationservice.entity.DeclarationProduit;
import stationservice.report.ReportFacture;
import stationservice.ressource.Methode;

public class DeclarationDetialsController implements Initializable {

    @FXML
    private Text id;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField decl_total;
    @FXML
    private JFXTextField decl_bons;
    @FXML
    private JFXTextField pompiste_nom;
    @FXML
    private JFXTextField pompiste_prenom;
    @FXML
    private JFXListView<ProduitDetailsCell> liste_produit;
    @FXML
    private JFXListView<BonsDetailsCell> liste_Bons;
    @FXML
    private JFXButton print;
    @FXML
    private JFXButton close;
    @FXML
    private JFXTextField debut;
    @FXML
    private JFXTextField fin;
    @FXML
    private JFXTextField billets;
    @FXML
    private JFXTextField avance;
    
    private Declaration declaration;
    @FXML
    private JFXTextField date1;
    @FXML
    private JFXTextField debut1;
    @FXML
    private JFXTextField fin1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void init(Declaration declaration) {
        this.declaration = declaration;
        set_information();

    }

    private void set_information() {
        id.setText(Integer.toString(this.declaration.getId()));
        date.setText(Methode.dateFormat(this.declaration.getDate()));
        debut.setText(this.declaration.getDebut_job());
        fin.setText(this.declaration.getFin_job());
        
        date1.setText(Methode.dateFormat(this.declaration.getDate2()));
        debut1.setText(this.declaration.getDebut_job2());
        fin1.setText(this.declaration.getFin_job2());
        
        
        decl_total.setText(Double.toString(declaration.getTotal()));
        decl_bons.setText(Double.toString(declaration.getBons()));
        billets.setText(""+this.declaration.getBillets());
        avance.setText(""+declaration.getAvance());
        

        pompiste_nom.setText(declaration.getIdpompiste().getNom());
        pompiste_prenom.setText(declaration.getIdpompiste().getPrenom());
        

        bons_liste();

        produit_liste();

    }

    private void produit_liste() {
        List<ProduitDetailsCell> list = new ArrayList<>();

        for (DeclarationProduit declarationProduit : this.declaration.getDeclarationProduits()) {
            ProduitDetailsCell cell = new ProduitDetailsCell(declarationProduit);
            list.add(cell);
        }

        ObservableList<ProduitDetailsCell> myObservableList = FXCollections.observableList(list);
        this.liste_produit.setItems(myObservableList);
        this.liste_produit.setExpanded(true);
    }

    private void bons_liste() {
        List<BonsDetailsCell> list = new ArrayList<>();

        for (Decbons decbons : this.declaration.getDecbonsCollection()) {
            BonsDetailsCell cell = new BonsDetailsCell(decbons);
            list.add(cell);
        }

        ObservableList<BonsDetailsCell> myObservableList = FXCollections.observableList(list);
        this.liste_Bons.setItems(myObservableList);
        this.liste_Bons.setExpanded(true);
    }

    @FXML
    private void print_action(ActionEvent event) {
        ReportFacture reportFacture = new ReportFacture(declaration);
        reportFacture.create_report();
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("etatup.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    @FXML
    private void close_action(ActionEvent event) {
        Stage stage = Methode.getStage(event);
        stage.close();
    }

}
