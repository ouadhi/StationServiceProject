package stationservice.controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import stationservice.entity.Decbons;
import stationservice.entity.Declaration;
import stationservice.entity.DeclarationProduit;
import stationservice.entity.Pompiste;
import stationservice.entity.Produit;
import stationservice.entity.Session;
import stationservice.model.BonsModel;
import stationservice.model.DeclarationBonsModel;
import stationservice.model.DeclarationModel;
import stationservice.model.DeclarationProduitModel;
import stationservice.model.PompisteModel;
import stationservice.model.ProduitModel;
import stationservice.model.UserModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class AddDeclarationController implements Initializable {

    @FXML
    private JFXTextField super1_ancien;
    @FXML
    private JFXTextField super1_nouveau;
    @FXML
    private JFXTextField super1_quantite;
    @FXML
    private JFXTextField super1_prix;
    @FXML
    private JFXTextField super1_total;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Text total_somme_produit;
    @FXML
    private JFXTextField SP1_ancien;
    @FXML
    private JFXTextField SP1_nouveau;
    @FXML
    private JFXTextField SP1_quantite;
    @FXML
    private JFXTextField SP1_prix;
    @FXML
    private JFXTextField SP1_total;
    @FXML
    private JFXTextField SP2_ancien;
    @FXML
    private JFXTextField SP2_nouveau;
    @FXML
    private JFXTextField SP2_quantite;
    @FXML
    private JFXTextField SP2_prix;
    @FXML
    private JFXTextField SP2_total;
    @FXML
    private JFXTextField gazoil_ancien3;
    @FXML
    private JFXTextField gazoil_nouveau;
    @FXML
    private JFXTextField gazoil_quantite;
    @FXML
    private JFXTextField gazoil_prix;
    @FXML
    private JFXTextField gazoil_total;
    @FXML
    private JFXTextField val_B1;
    @FXML
    private JFXTextField somme_B1;
    @FXML
    private JFXTextField val_B4;
    @FXML
    private JFXTextField somme_B4;
    @FXML
    private JFXTextField val_B2;
    @FXML
    private JFXTextField somme_B2;
    @FXML
    private JFXTextField somme_B5;
    @FXML
    private JFXTextField val_B3;
    @FXML
    private JFXTextField somme_B3;
    @FXML
    private JFXTextField val_B6;
    @FXML
    private JFXTextField somme_B6;
    @FXML
    private Text total_somme_bons;
    @FXML
    private JFXTextField val_B5;
    @FXML
    private JFXTextField montant;
    @FXML
    private JFXTextField peso;
    @FXML
    private JFXTextField difference;
    @FXML
    private JFXButton save_bttn;
    @FXML
    private JFXButton annuler_bttn;
    private Declaration declaration;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXButton liste;
    @FXML
    private HBox hbox;
    private ComboBox<HideableItem<String>> comboBox;
    @FXML
    private JFXTextField avance;
    @FXML
    private JFXTextField total_avance;
    @FXML
    private JFXTextField monnaie_avance;
    @FXML
    private JFXDatePicker debut;
    @FXML
    private JFXDatePicker fin;

    /*
    /@ variables  
     */
    private double somme_super, somme_gazoil, somme_SP1, somme_SP2, somme_total = 0;
    private double somme_B1_val, somme_B2_val, somme_B3_val, somme_B4_val, somme_B5_val, somme_B6_val, somme_total_b = 0;
    private double montant_val, espece_val, difference_val = 0;
    private DeclarationProduit dec_super, decl_sans_plomb1, decl_sans_plomb2, decl_gazoil;
    @FXML
    private JFXDatePicker date1;
    @FXML
    private JFXDatePicker debut1;
    @FXML
    private JFXDatePicker fin1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setAllOnlyNumbres();
        setAllZero();

        super1_prix.setText(Float.toString(ProduitModel.getSuper().getPrix()));
        SP1_prix.setText(Float.toString(ProduitModel.getSp1().getPrix()));
        SP2_prix.setText(Float.toString(ProduitModel.getSp2().getPrix()));
        gazoil_prix.setText(Float.toString(ProduitModel.getGasoil().getPrix()));
        date.setValue(LocalDate.now());
        date1.setValue(LocalDate.now());

        comboBox = createComboBoxWithAutoCompletionSupport(PompisteModel.pompiste_nom_prenom());
        comboBox.setMaxWidth(Double.MAX_VALUE);
        hbox.getChildren().add(comboBox);

        avance.setText("10000");

        fin.setTime(LocalTime.of(20, 00));
        debut.setTime(LocalTime.of(8, 00));
        
        fin1.setTime(LocalTime.of(20, 00));
        debut1.setTime(LocalTime.of(8, 00));

        super1_ancien.setText(Integer.toString(ProduitModel.getSuper().getCompteur()));
        SP2_ancien.setText(Integer.toString(ProduitModel.getSp2().getCompteur()));
        SP1_ancien.setText(Integer.toString(ProduitModel.getSp1().getCompteur()));
        gazoil_ancien3.setText(Integer.toString(ProduitModel.getGasoil().getCompteur()));

        super1_nouveau.setText(Integer.toString(ProduitModel.getSuper().getCompteur()));
        SP2_nouveau.setText(Integer.toString(ProduitModel.getSp2().getCompteur()));
        SP1_nouveau.setText(Integer.toString(ProduitModel.getSp1().getCompteur()));
        gazoil_nouveau.setText(Integer.toString(ProduitModel.getGasoil().getCompteur()));

    }

    @FXML
    private void super1_nouveau_typed(KeyEvent event) {
        super1();
    }

    @FXML
    private void super1_nouveau_presed(KeyEvent event) {
        super1();
    }

    @FXML
    private void super1_nouveau_relased(KeyEvent event) {
        super1();
    }

    @FXML
    private void super1_change(InputMethodEvent event) {
        super1();
    }

    private void super1() {
        if (!this.super1_ancien.getText().equals("")) {
            int nouveau = 0;
            if (!this.super1_nouveau.getText().equals("")) {
                nouveau = Integer.parseInt(this.super1_nouveau.getText());
            }

            int ancien = Integer.parseInt(this.super1_ancien.getText());
            int quantite = 0;
            if (ancien > nouveau) {
                quantite = ancien - nouveau;
            } else {
                quantite = nouveau - ancien;
            }
            this.super1_quantite.setText(Integer.toString(quantite));

            double prix = Double.parseDouble(this.super1_prix.getText());
            this.somme_super = prix * quantite;
            this.super1_total.setText(Double.toString(this.somme_super));
            somme_produit();
        } else {
            Notification.champVideNotification();
            this.super1_nouveau.setText("");
        }

    }

    /*
    __________________________________________________________________________________________________________________
     */
    @FXML
    private void SP1_change(InputMethodEvent event) {
        sans_p1();
    }

    @FXML
    private void SP1_nouveau_presed(KeyEvent event) {
        sans_p1();
    }

    @FXML
    private void SP1_nouveau_relased(KeyEvent event) {
        sans_p1();
    }

    @FXML
    private void SP1_nouveau_typed(KeyEvent event) {
        sans_p1();
    }

    private void sans_p1() {
        if (!this.SP1_ancien.getText().equals("")) {
            int nouveau = 0;
            if (!this.SP1_nouveau.getText().equals("")) {
                nouveau = Integer.parseInt(this.SP1_nouveau.getText());
            }

            int ancien = Integer.parseInt(this.SP1_ancien.getText());
            int quantite = 0;
            if (ancien > nouveau) {
                quantite = ancien - nouveau;
            } else {
                quantite = nouveau - ancien;
            }
            this.SP1_quantite.setText(Integer.toString(quantite));

            double prix = Double.parseDouble(this.SP1_prix.getText());
            this.somme_SP1 = prix * quantite;
            this.SP1_total.setText(Double.toString(this.somme_SP1));
            somme_produit();
        } else {
            Notification.champVideNotification();
            this.SP1_nouveau.setText("");
        }

    }

    /*
    __________________________________________________________________________________________________________________
     */
    @FXML
    private void SP2_change(InputMethodEvent event) {
        sans_p2();
    }

    @FXML
    private void SP2_nouveau_presed(KeyEvent event) {
        sans_p2();
    }

    @FXML
    private void SP2_nouveau_relased(KeyEvent event) {
        sans_p2();
    }

    @FXML
    private void SP2_nouveau_typed(KeyEvent event) {
        sans_p2();
    }

    private void sans_p2() {
        if (!this.SP2_ancien.getText().equals("")) {
            int nouveau = 0;
            if (!this.SP2_nouveau.getText().equals("")) {
                nouveau = Integer.parseInt(this.SP2_nouveau.getText());
            }

            int ancien = Integer.parseInt(this.SP2_ancien.getText());
            int quantite = 0;
            if (ancien > nouveau) {
                quantite = ancien - nouveau;
            } else {
                quantite = nouveau - ancien;
            }
            this.SP2_quantite.setText(Integer.toString(quantite));

            double prix = Double.parseDouble(this.SP2_prix.getText());
            this.somme_SP2 = prix * quantite;
            this.SP2_total.setText(Double.toString(this.somme_SP2));

            somme_produit();

        } else {
            Notification.champVideNotification();
            this.SP2_nouveau.setText("");
        }

    }

    /*
    __________________________________________________________________________________________________________________
     */
    @FXML
    private void gazoil_change(InputMethodEvent event) {
        gazoil();
    }

    @FXML
    private void gazoil_nouveau_presed(KeyEvent event) {
        gazoil();
    }

    @FXML
    private void gazoil_nouveau_relased(KeyEvent event) {
        gazoil();
    }

    @FXML
    private void gazoil_nouveau_typed(KeyEvent event) {
        gazoil();
    }

    private void gazoil() {
        if (!this.gazoil_ancien3.getText().equals("")) {
            int nouveau = 0;
            if (!this.gazoil_nouveau.getText().equals("")) {
                nouveau = Integer.parseInt(this.gazoil_nouveau.getText());
            }

            int ancien = Integer.parseInt(this.gazoil_ancien3.getText());
            int quantite = 0;
            if (ancien > nouveau) {
                quantite = ancien - nouveau;
            } else {
                quantite = nouveau - ancien;
            }
            this.gazoil_quantite.setText(Integer.toString(quantite));

            double prix = Double.parseDouble(this.gazoil_prix.getText());
            this.somme_gazoil = prix * quantite;
            this.gazoil_total.setText(Double.toString(this.somme_gazoil));
            somme_produit();
        } else {
            Notification.champVideNotification();
            this.gazoil_nouveau.setText("");
        }

    }

    @FXML
    private void pressed_B1(KeyEvent event) {
        B1();
    }

    @FXML
    private void released_B1(KeyEvent event) {
        B1();
    }

    @FXML
    private void typed_B1(KeyEvent event) {
        B1();
    }

    private void B1() {
        int nb = 0;
        if (!val_B1.getText().equals("")) {
            nb = Integer.parseInt(val_B1.getText());
        }
        double prix = 1150;
        somme_B1_val = nb * prix;

        somme_B1.setText(Double.toString(somme_B1_val));
        somme_bons();
    }

    @FXML
    private void pressed_B2(KeyEvent event) {
        B2();
    }

    @FXML
    private void released_B2(KeyEvent event) {
        B2();
    }

    @FXML
    private void typed_B2(KeyEvent event) {
        B2();
    }

    private void B2() {
        int nb = 0;
        if (!val_B2.getText().equals("")) {
            nb = Integer.parseInt(val_B2.getText());
        }
        double prix = 850;
        somme_B2_val = nb * prix;

        somme_B2.setText(Double.toString(somme_B2_val));
        somme_bons();
    }

    @FXML
    private void pressed_B3(KeyEvent event) {
        B3();
    }

    @FXML
    private void released_B3(KeyEvent event) {
        B3();
    }

    @FXML
    private void typed_B3(KeyEvent event) {
        B3();
    }

    private void B3() {
        int nb = 0;
        if (!val_B3.getText().equals("")) {
            nb = Integer.parseInt(val_B3.getText());
        }
        double prix = 839;
        somme_B3_val = nb * prix;

        somme_B3.setText(Double.toString(somme_B3_val));
        somme_bons();
    }

    @FXML
    private void pressed_B4(KeyEvent event) {
        B4();
    }

    @FXML
    private void released_B4(KeyEvent event) {
        B4();
    }

    @FXML
    private void typed_B4(KeyEvent event) {
        B4();
    }

    private void B4() {
        int nb = 0;
        if (!val_B4.getText().equals("")) {
            nb = Integer.parseInt(val_B4.getText());
        }
        double prix = 690;
        somme_B4_val = nb * prix;

        somme_B4.setText(Double.toString(somme_B4_val));
        somme_bons();
    }

    @FXML
    private void pressed_B5(KeyEvent event) {
        B5();
    }

    @FXML
    private void released_B5(KeyEvent event) {
        B5();
    }

    @FXML
    private void typed_B5(KeyEvent event) {
        B5();
    }

    private void B5() {
        int nb = 0;
        if (!val_B5.getText().equals("")) {
            nb = Integer.parseInt(val_B5.getText());
        }
        double prix = 416;
        somme_B5_val = nb * prix;

        somme_B5.setText(Double.toString(somme_B5_val));
        somme_bons();
    }

    @FXML
    private void pressed_B6(KeyEvent event) {
        B6();
    }

    @FXML
    private void released_B6(KeyEvent event) {
        B6();
    }

    @FXML
    private void typed_B6(KeyEvent event) {
        B6();
    }

    private void B6() {
        int nb = 0;
        if (!val_B6.getText().equals("")) {
            nb = Integer.parseInt(val_B6.getText());
        }
        double prix = 332;
        somme_B6_val = nb * prix;

        somme_B6.setText(Double.toString(somme_B6_val));
        somme_bons();
    }

    private void setAllOnlyNumbres() {
        for (Node node : Methode.getAllNodes(rootpane)) {
            if (node instanceof JFXTextField && !node.getId().equals("monnaie_avance")) {
                JFXTextField text = (JFXTextField) node;
                Methode.setOnlyNumbre(text);
                Methode.setSelectedMouseClick(text);
            }
        }
        

    }

    private void setAllZero() {
        for (Node node : Methode.getAllNodes(rootpane)) {
            if (node instanceof JFXTextField) {
                JFXTextField text = (JFXTextField) node;
                text.setText("0");
            }
        }
    }

    private void somme_produit() {
        somme_total = somme_super + somme_gazoil + somme_SP1 + somme_SP2;
        total_somme_produit.setText(Double.toString(this.somme_total));
        calcule_montant();

        float total_avance = (float)this.somme_total - Float.parseFloat(this.avance.getText());
        this.total_avance.setText(Double.toString(total_avance));
    }

    private void somme_bons() {
        somme_total_b = somme_B1_val + somme_B2_val + somme_B3_val + somme_B4_val + somme_B5_val + somme_B6_val;
        total_somme_bons.setText(Double.toString(this.somme_total_b));
        calcule_montant();
    }

    @FXML
    private void peso_pressed(KeyEvent event) {
        calcule_difference();
    }

    @FXML
    private void peso_released(KeyEvent event) {
        calcule_difference();
    }

    @FXML
    private void peso_typed(KeyEvent event) {
        calcule_difference();
    }

    private void calcule_difference() {
        if (montant.getText().equals("")) {
            Notification.champVideNotification();
            this.peso.setText("");
        } else {
            float diff = 0;
            float peso_val = 0;
            if (!peso.getText().equals("")) {
                peso_val = Float.parseFloat(peso.getText());
            }
            diff =(float) montant_val - peso_val;
            float monnie_avance = diff - Float.parseFloat(avance.getText());
            String moString = Float.toString(monnie_avance) ; 
            this.difference.setText(""+diff);
            this.monnaie_avance.setText(""+moString);

        }
    }

    private void calcule_montant() {
        this.montant_val = this.somme_total - this.somme_total_b;
        this.montant.setText(Double.toString(montant_val));
    }

    @FXML
    private void save_action(ActionEvent event) {

        if (testQunatity()) {
            save();
        }else {
            Notification.WarningQunatite() ;
        }

    }

    private boolean testQunatity() throws NumberFormatException {
        return ProduitModel.getSuper().testQuantity(Integer.parseInt(super1_quantite.getText()))
                & ProduitModel.getSp1().testQuantity(Integer.parseInt(SP1_quantite.getText()))
                & ProduitModel.getSp2().testQuantity(Integer.parseInt(SP2_quantite.getText()))
                & ProduitModel.getGasoil().testQuantity(Integer.parseInt(gazoil_quantite.getText()));
    }

    private Pompiste selected_pompiste() {

        String item = comboBox.getSelectionModel().getSelectedItem().getObject().toString();
        String[] tab = item.split("-");
        Pompiste pompiste = PompisteModel.get_pompist_by_nom_prenom(tab[0], tab[1]);
        return pompiste;
    }

    private void save() {
        // controle  save 
        //  temps de  travail 
        String time_debut = this.debut.getTime().toString();
        String time_fin = this.fin.getTime().toString();
        
        String time_debut1 = this.debut1.getTime().toString();
        String time_fin1 = this.fin1.getTime().toString();

        // la date de  travaille  
        Date date = Date.from(this.date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date1 = Date.from(this.date1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDay = new Date();

        try {

            if (date.compareTo(toDay) > 0) {
                Notification.WarningToDateAlert().show();
                System.out.println(date);
                return;
            }

            if (date.after(DeclarationModel.getMaxDate())) {
                // recalcule  les valeurs pour assuree  integrete des donnees 
                recalcule();
                
                /*
                tester  si  les quantites confirme  les reservoirs
                */
                
                doSave(date, time_debut, time_fin , date1 , time_debut1 , time_fin1);


            } else {
                Notification.WarningMaxDateAlert().show();
            }

        } catch (Exception e) {
            Notification.errorAlert(e.getMessage());
        }

    }

    private void doSave(Date date1, String time_debut, String time_fin ,Date date2, String time_debut1, String time_fin1 ) throws NumberFormatException {
        declaration = new Declaration();
        declaration.setBons(somme_total_b);
        declaration.setDate(date1);
        declaration.setDate2(date2);
        declaration.setTotal(somme_total);
        declaration.setIdpompiste(selected_pompiste());
        declaration.setDebut_job(time_debut);
        declaration.setFin_job(time_fin);
        declaration.setDebut_job2(time_debut1);
        declaration.setFin_job2(time_fin1);
        declaration.setAvance(Double.parseDouble(avance.getText()));
        declaration.setBillets(Double.parseDouble(peso.getText()));
        declaration.setIduser(UserModel.getByName(Session.user.getUsername()));
        
        DeclarationModel.save(declaration);
        SaveBonsProduit(date1);
        updateLasteCounter();
        Notification.Addnotification();
        
    }

    //  modifier etat du  carburants  
    private void updateLasteCounter() throws NumberFormatException {

        Produit pm = ProduitModel.getSuper();
        pm.setCompteur(Integer.parseInt(super1_nouveau.getText()));
        pm.consumedQuantity(Integer.parseInt(super1_quantite.getText()));
        ProduitModel.save(pm);

        pm = ProduitModel.getSp1();
        pm.setCompteur(Integer.parseInt(SP1_nouveau.getText()));
        pm.consumedQuantity(Integer.parseInt(SP1_quantite.getText()));
        ProduitModel.save(pm);

        pm = ProduitModel.getSp2();
        pm.setCompteur(Integer.parseInt(SP2_nouveau.getText()));
        pm.consumedQuantity(Integer.parseInt(SP2_quantite.getText()));
        ProduitModel.save(pm);

        pm = ProduitModel.getGasoil();
        pm.setCompteur(Integer.parseInt(gazoil_nouveau.getText()));
        pm.consumedQuantity(Integer.parseInt(gazoil_quantite.getText()));
        ProduitModel.save(pm);
    }

    private void SaveBonsProduit(Date date1) throws NumberFormatException {

        DeclarationProduit decl_pro1 = new DeclarationProduit(Double.parseDouble(super1_prix.getText()), Integer.parseInt(super1_nouveau.getText()),
                Integer.parseInt(super1_ancien.getText()), Integer.parseInt(super1_quantite.getText()),
                Double.parseDouble(super1_total.getText()), declaration, ProduitModel.getByDesignation("super"));
        DeclarationProduitModel.save(decl_pro1);

        DeclarationProduit decl_pro2 = new DeclarationProduit(Double.parseDouble(SP1_prix.getText()), Integer.parseInt(SP1_nouveau.getText()), Integer.parseInt(SP1_ancien.getText()), Integer.parseInt(SP1_quantite.getText()), Double.parseDouble(SP1_total.getText()), declaration, ProduitModel.getByDesignation("sans plomb1"));
        DeclarationProduitModel.save(decl_pro2);

        DeclarationProduit decl_pro3 = new DeclarationProduit(Double.parseDouble(SP2_prix.getText()), Integer.parseInt(SP2_nouveau.getText()), Integer.parseInt(SP2_ancien.getText()), Integer.parseInt(SP2_quantite.getText()), Double.parseDouble(SP2_total.getText()), declaration, ProduitModel.getByDesignation("sans plomb2"));
        DeclarationProduitModel.save(decl_pro3);

        DeclarationProduit decl_pro4 = new DeclarationProduit(Double.parseDouble(gazoil_prix.getText()), Integer.parseInt(gazoil_nouveau.getText()), Integer.parseInt(gazoil_ancien3.getText()), Integer.parseInt(gazoil_quantite.getText()), Double.parseDouble(gazoil_total.getText()), declaration, ProduitModel.getByDesignation("gazoil"));
        DeclarationProduitModel.save(decl_pro4);

        //  bons  relations 
        Decbons decbons = new Decbons(date1, Integer.parseInt(val_B1.getText()), Double.parseDouble(somme_B1.getText()), declaration, BonsModel.getone("bons1150"));
        DeclarationBonsModel.save(decbons);

        Decbons decbons1 = new Decbons(date1, Integer.parseInt(val_B2.getText()), Double.parseDouble(somme_B2.getText()), declaration, BonsModel.getone("bons850"));
        DeclarationBonsModel.save(decbons1);

        Decbons decbons2 = new Decbons(date1, Integer.parseInt(val_B3.getText()), Double.parseDouble(somme_B3.getText()), declaration, BonsModel.getone("bons839"));
        DeclarationBonsModel.save(decbons2);

        Decbons decbons3 = new Decbons(date1, Integer.parseInt(val_B4.getText()), Double.parseDouble(somme_B3.getText()), declaration, BonsModel.getone("bons690"));
        DeclarationBonsModel.save(decbons3);

        Decbons decbons4 = new Decbons(date1, Integer.parseInt(val_B5.getText()), Double.parseDouble(somme_B5.getText()), declaration, BonsModel.getone("bons416"));
        DeclarationBonsModel.save(decbons4);

        Decbons decbons5 = new Decbons(date1, Integer.parseInt(val_B6.getText()), Double.parseDouble(somme_B6.getText()), declaration, BonsModel.getone("bons332"));
        DeclarationBonsModel.save(decbons5);
    }

    @FXML
    private void annuler_action(ActionEvent event) {
    }

    @FXML
    private void liste_bttn(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/DeclarationListe.fxml"));
            HomeController.staticMainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public static class HideableItem<T> {

        private final ObjectProperty<T> object = new SimpleObjectProperty<>();
        private final BooleanProperty hidden = new SimpleBooleanProperty();

        private HideableItem(T object) {
            setObject(object);
        }

        private ObjectProperty<T> objectProperty() {
            return this.object;
        }

        private T getObject() {
            return this.objectProperty().get();
        }

        private void setObject(T object) {
            this.objectProperty().set(object);
        }

        private BooleanProperty hiddenProperty() {
            return this.hidden;
        }

        private boolean isHidden() {
            return this.hiddenProperty().get();
        }

        private void setHidden(boolean hidden) {
            this.hiddenProperty().set(hidden);
        }

        @Override
        public String toString() {
            return getObject() == null ? null : getObject().toString();
        }
    }

    private static <T> ComboBox<HideableItem<T>> createComboBoxWithAutoCompletionSupport(List<T> items) {
        ObservableList<HideableItem<T>> hideableHideableItems = FXCollections.observableArrayList(hideableItem -> new Observable[]{hideableItem.hiddenProperty()});

        items.forEach(item
                -> {
            HideableItem<T> hideableItem = new HideableItem<>(item);
            hideableHideableItems.add(hideableItem);
        });

        FilteredList<HideableItem<T>> filteredHideableItems = new FilteredList<>(hideableHideableItems, t -> !t.isHidden());

        ComboBox<HideableItem<T>> comboBox = new ComboBox<>();
        comboBox.setItems(filteredHideableItems);

        @SuppressWarnings("unchecked")
        HideableItem<T>[] selectedItem = (HideableItem<T>[]) new HideableItem[1];

        comboBox.addEventHandler(KeyEvent.KEY_PRESSED, event
                -> {
            if (!comboBox.isShowing()) {
                return;
            }

            comboBox.setEditable(true);
            comboBox.getEditor().clear();
        });

        comboBox.showingProperty().addListener((observable, oldValue, newValue)
                -> {
            if (newValue) {
                @SuppressWarnings("unchecked")
                ListView<HideableItem> lv = ((ComboBoxListViewSkin<HideableItem>) comboBox.getSkin()).getListView();

                Platform.runLater(()
                        -> {
                    if (selectedItem[0] == null) // first use
                    {
                        double cellHeight = ((Control) lv.lookup(".list-cell")).getHeight();
                        lv.setFixedCellSize(cellHeight);
                    }
                });

                lv.scrollTo(comboBox.getValue());
            } else {
                HideableItem<T> value = comboBox.getValue();
                if (value != null) {
                    selectedItem[0] = value;
                }

                comboBox.setEditable(false);

                Platform.runLater(()
                        -> {
                    comboBox.getSelectionModel().select(selectedItem[0]);
                    comboBox.setValue(selectedItem[0]);
                });
            }
        });

        comboBox.setOnHidden(event -> hideableHideableItems.forEach(item -> item.setHidden(false)));

        comboBox.getEditor().textProperty().addListener((obs, oldValue, newValue)
                -> {
            if (!comboBox.isShowing()) {
                return;
            }

            Platform.runLater(()
                    -> {
                if (comboBox.getSelectionModel().getSelectedItem() == null) {
                    hideableHideableItems.forEach(item -> item.setHidden(!item.getObject().toString().toLowerCase().contains(newValue.toLowerCase())));
                } else {
                    boolean validText = false;

                    for (HideableItem hideableItem : hideableHideableItems) {
                        if (hideableItem.getObject().toString().equals(newValue)) {
                            validText = true;
                            break;
                        }
                    }

                    if (!validText) {
                        comboBox.getSelectionModel().select(null);
                    }
                }
            });
        });

        return comboBox;

    }

    public void recalcule() {

        //  carburants  
        super1();
        sans_p1();
        sans_p2();
        gazoil();

        //  bons  
        B1();
        B2();
        B3();
        B4();
        B5();
        B6();

        calcule_difference();

    }

}
