package stationservice.controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import stationservice.entity.Declaration;
import stationservice.entity.Pompiste;
import stationservice.model.DeclarationModel;
import stationservice.model.PompisteModel;
import stationservice.ressource.Methode;
import stationservice.ressource.Notification;

public class DeclarationController implements Initializable {

    @FXML
    private JFXTextField sp1_anc;
    @FXML
    private JFXTextField sp1_quan;
    @FXML
    private JFXTextField sp1_total;
    @FXML
    private JFXTextField sp2_anc;
    @FXML
    private JFXTextField sp2_nouc;
    @FXML
    private JFXTextField sp2_quan;
    @FXML
    private JFXTextField sp2_total;
    @FXML
    private JFXTextField super_anc;
    @FXML
    private JFXTextField super_nouv;
    @FXML
    private JFXTextField super_quan;
    @FXML
    private JFXTextField super_prix;
    @FXML
    private JFXTextField super_total;
    @FXML
    private JFXTextField gazoil_anc;
    @FXML
    private JFXTextField gazoil_nouv;
    @FXML
    private JFXTextField gazoil_quan;
    @FXML
    private JFXTextField gazoil_prix;
    @FXML
    private JFXTextField gazoil_total;
    @FXML
    private JFXTextField n850;
    @FXML
    private JFXTextField somme850;
    @FXML
    private JFXTextField n690;
    @FXML
    private JFXTextField somme690;
    @FXML
    private JFXTextField n839;
    @FXML
    private JFXTextField somme839;
    @FXML
    private JFXTextField n332;
    @FXML
    private JFXTextField somme332;
    @FXML
    private JFXTextField n416;
    @FXML
    private JFXTextField somme416;
    @FXML
    private JFXTextField n1150;
    @FXML
    private JFXTextField somme1150;
    @FXML
    private JFXTextField total_carburant;
    @FXML
    private JFXTextField total_tac;
    @FXML
    private JFXTextField total_espace;
    @FXML
    private JFXTextField sp1_nouv;
    @FXML
    private JFXTextField sp1_prix;
    @FXML
    private AnchorPane declarationSceen;
    @FXML
    private JFXTextField sp2_prix;

    //  variable  
    double somme_sp1, somme_sp2, somme_super, somme_gazoil, somme_carbirant = 0;
    double s850, s690, s839, s332, s416, s1150 = 0;
    double somme_carbrant_var, somme_ATC_var = 0;
    double total_espace_var = 0;
    double reste = 0;
    @FXML
    private JFXTextField casse;
    @FXML
    private JFXTextField defference;
    @FXML
    private JFXButton annuler_bttn;
    @FXML
    private JFXButton save_button;
    @FXML
    private JFXButton Lostebttn;
    @FXML
    private JFXButton nouveau_bttn;
    @FXML
    private JFXComboBox<?> pompiste_liste;
    @FXML
    private JFXDatePicker date_decl;

    private Declaration declaration = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPrice();
        setAllOnlyNumbres();

    }

    @FXML
    private void cal_sp1(KeyEvent event) {
        try {
            int anc = Integer.parseInt(sp1_anc.getText());
            int nouv = Integer.parseInt(sp1_nouv.getText());
            int qun = anc - nouv;

            sp1_quan.setText(Integer.toString(qun));

            int prix_unit = Integer.parseInt(sp1_prix.getText());
            double prix = prix_unit * qun;

            sp1_total.setText(Double.toString(prix));
            somme_sp1 = prix;
            calcule_somme_total_carburant();

        } catch (Exception e) {
            Notification.errorNotification();
        }

    }

    @FXML
    private void cal_sp2(KeyEvent event) {
        try {
            int anc = Integer.parseInt(sp2_anc.getText());
            int nouv = Integer.parseInt(sp2_nouc.getText());
            int qun = anc - nouv;

            sp2_quan.setText(Integer.toString(qun));

            int prix_unit = Integer.parseInt(sp2_prix.getText());
            double prix = prix_unit * qun;
            sp2_total.setText(Double.toString(prix));

            somme_sp2 = prix;
            calcule_somme_total_carburant();

        } catch (Exception e) {
            Notification.errorNotification();
        }
    }

    @FXML
    private void cal_super(KeyEvent event) {
        try {
            int anc = Integer.parseInt(super_anc.getText());
            int nouv = Integer.parseInt(super_nouv.getText());
            int qun = anc - nouv;
            super_quan.setText(Integer.toString(qun));

            int prix_unit = Integer.parseInt(super_prix.getText());
            double prix = prix_unit * qun;
            super_total.setText(Double.toString(prix));

            somme_super = prix;
            calcule_somme_total_carburant();

        } catch (Exception e) {
            Notification.errorNotification();
        }
    }

    @FXML
    private void cal_gazoil(KeyEvent event) {
        try {
            int anc = Integer.parseInt(gazoil_anc.getText());
            int nouv = Integer.parseInt(gazoil_nouv.getText());
            int qun = anc - nouv;
            gazoil_quan.setText(Integer.toString(qun));

            int prix_unit = Integer.parseInt(gazoil_prix.getText());
            double prix = prix_unit * qun;
            gazoil_total.setText(Double.toString(prix));

            somme_gazoil = prix;
            calcule_somme_total_carburant();

        } catch (Exception e) {
            Notification.errorNotification();
        }
    }

    @FXML
    private void cal850(KeyEvent event) {
        try {
            int nb = Integer.parseInt(n850.getText());
            s850 = nb * 850;
            somme850.setText(Double.toString(s850));

            somme_total_TAC();
        } catch (Exception e) {
            Notification.errorNotification();
        }

    }

    @FXML
    private void cal690(KeyEvent event) {
        try {
            int nb = Integer.parseInt(n690.getText());
            s690 = nb * 690;
            somme690.setText(Double.toString(s690));

            somme_total_TAC();

        } catch (Exception e) {
            Notification.errorNotification();
        }

    }

    @FXML
    private void cal839(KeyEvent event) {
        int nb = Integer.parseInt(n839.getText());
        s839 = nb * 839;
        somme839.setText(Double.toString(s839));

        somme_total_TAC();
    }

    @FXML
    private void cal332(KeyEvent event) {
        try {
            int nb = Integer.parseInt(n332.getText());
            s332 = nb * 332;
            somme332.setText(Double.toString(s332));

            somme_total_TAC();
        } catch (Exception e) {
            Notification.errorNotification();
        }

    }

    @FXML
    private void cal416(KeyEvent event) {
        try {
            int nb = Integer.parseInt(n416.getText());
            s416 = nb * 416;
            somme416.setText(Double.toString(s416));

            somme_total_TAC();
        } catch (Exception e) {
            Notification.errorNotification();
        }

    }

    @FXML
    private void cal1150(KeyEvent event) {
        try {
            int nb = Integer.parseInt(n1150.getText());
            s1150 = nb * 1150;
            somme1150.setText(Double.toString(s1150));

            somme_total_TAC();
        } catch (Exception e) {
            Notification.errorNotification();
        }

    }

    // calcule la  sommme  total  de  carburant  
    private void calcule_somme_total_carburant() {
        somme_carbrant_var = somme_sp1 + somme_sp2 + somme_super + somme_gazoil;
        total_carburant.setText(Double.toString(somme_carbrant_var));

        total_espace_var = somme_carbrant_var - somme_ATC_var;
        total_espace.setText(Double.toString(total_espace_var));

    }

    //  montant total de TAC 
    private void somme_total_TAC() {
        somme_ATC_var = s1150 + s332 + s416 + s690 + s690 + s839 + s850;
        total_tac.setText(Double.toString(somme_ATC_var));

        total_espace_var = somme_carbrant_var - somme_ATC_var;
        total_espace.setText(Double.toString(total_espace_var));
    }

    @FXML
    private void caisse_pressed(KeyEvent event) {
        reste = total_espace_var - Double.parseDouble(casse.getText());

        defference.setText(Double.toString(reste));
    }

    private void setAllOnlyNumbres() {
        for (Node node : Methode.getAllNodes(declarationSceen)) {
            if (node instanceof JFXTextField) {
                JFXTextField text = (JFXTextField) node;
                Methode.setOnlyNumbre(text);
            }
        }
    }

    private void clear() {
        for (Node node : Methode.getAllNodes(declarationSceen)) {
            if (node instanceof JFXTextField) {
                JFXTextField text = (JFXTextField) node;
                text.setText("");
            }
        }
        setPrice();

        somme_sp1 = somme_sp2 = somme_super = somme_gazoil = somme_carbirant = 0;
        s850 = s690 = s839 = s332 = s416 = s1150 = 0;
        somme_carbrant_var = somme_ATC_var = 0;
        total_espace_var = 0;
        reste = 0;
    }

    private void setPrice() {
        sp1_prix.setText("10");
        sp2_prix.setText("10");
        super_prix.setText("10");
        gazoil_prix.setText("10");
    }

    @FXML
    private void cancelAction(ActionEvent event) {
    }

    @FXML
    private void SaveAction(ActionEvent event) {
        Date date = Date.from(this.date_decl.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.declaration = new Declaration();
        declaration.setDate(date);
        declaration.setTotal(somme_carbrant_var);
        declaration.setBons(somme_ATC_var);
        
        Pompiste pompiste = PompisteModel.getPompisteById(8);
        
        System.out.println(pompiste.toString());
        declaration.setIdpompiste(pompiste);

        DeclarationModel.save(declaration);
        Notification.Addnotification();

    }

    @FXML
    private void listeAction(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/stationservice/view/DeclarationListe.fxml"));
            HomeController.staticMainPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void nouveauAction(ActionEvent event) {
        clear();
    }

}
