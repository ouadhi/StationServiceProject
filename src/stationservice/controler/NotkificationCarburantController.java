package stationservice.controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import stationservice.entity.Produit;
import stationservice.model.ProduitModel;
import stationservice.ressource.Methode;

public class NotkificationCarburantController implements Initializable {

    @FXML
    private Text super_quantite;
    @FXML
    private Text sp1_quantite;
    @FXML
    private Text sp2_quantite;
    @FXML
    private Text gazoil_quantite;
    @FXML
    private ImageView super_icon;
    @FXML
    private ImageView sp1_icon;
    @FXML
    private ImageView sp2_icon;
    @FXML
    private ImageView gaazoil_icon;

    private String green, orange, red;
    
    private Produit sup , sp1 , sp2  , gazoil  ; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.green = "/stationservice/imgs/green.png";
        this.orange = "/stationservice/imgs/orange.png";
        this.red = "/stationservice/imgs/red.png";
        
        this.sup = ProduitModel.getSuper() ; 
        this.sp1 = ProduitModel.getSp1() ; 
        this.sp2 = ProduitModel.getSp2()  ;  
        this.gazoil = ProduitModel.getGasoil() ; 
        
        
        
 
        
       super_quantite.setText(""+this.sup.getQuantite());
       sp1_quantite.setText(""+this.sp1.getQuantite());
       sp2_quantite.setText(""+this.sp2.getQuantite());
       gazoil_quantite.setText(""+this.gazoil.getQuantite());
        
        
        this.super_icon.setImage(new Image(getClass().getResource(geticon(sup.etatProduit())).toExternalForm()));
        this.sp1_icon.setImage(new Image(getClass().getResource(geticon(sp1.etatProduit())).toExternalForm()));
        this.sp2_icon.setImage(new Image(getClass().getResource(geticon(sp2.etatProduit())).toExternalForm()));
        this.gaazoil_icon.setImage(new Image(getClass().getResource(geticon(gazoil.etatProduit())).toExternalForm()));

    }
    
    
    private String geticon (int nb ){
        
        if (nb  == 0 ) {
            return   red  ; 
        } else {
            if (nb == 1 ) {
                return  orange ; 
            }else{
                return green ; 
            }
        }
        
    }

    @FXML
    private void close(MouseEvent event) {
        Methode.getStageMouses(event).close();
    }

}
