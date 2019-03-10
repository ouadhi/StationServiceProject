
package stationservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import stationservice.ressource.Notification;


@Entity
@Table(name = "produit")

public class Produit implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "disignations")
    private String disignations;
    
    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @Column(name="quantite")
    private float quantite ;
    
    @Column(name = "max")
    private int max;
    
    @Column(name = "min")
    private int min;
    
    @Column(name ="compteur")
    private int compteur  ; 
    
    @Column 
    private float  prix  ; 
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduit")
    private List<DeclarationProduit> declarationProduitsCollection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisignations() {
        return disignations;
    }

    public void setDisignations(String disignations) {
        this.disignations = disignations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
   
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    

    public List<DeclarationProduit> getDeclarationProduitsCollection() {
        return declarationProduitsCollection;
    }

    public void setDeclarationProduitsCollection(List<DeclarationProduit> declarationProduitsCollection) {
        this.declarationProduitsCollection = declarationProduitsCollection;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", disignations=" + disignations + ", quantite=" + quantite + ", max=" + max + ", min=" + min + ", compteur=" + compteur + "etat"+this.etatProduit()+'}';
    }

    
    
     public void consumedQuantity(int quantityConsumed ) {
        
        if (quantityConsumed>  this.quantite) {
            Notification.error("impossibl de  consumer  cette  quntitte");
        } else {
             this.quantite  =  this.quantite - quantityConsumed  ; 
             System.out.println("consumed  quantite" + this.getDisignations());
        } 
    } 
     
     public boolean  testQuantity(int quantityConsumed ) {
         
        if (quantityConsumed >  this.quantite) {
            Notification.WarningQunatite(this.getDisignations()).show();  
            return false    ; 
        } else {
            return   true  ; 
        }     
    } 
     
     /*
     *  0  => vert 
     *  1 => orange 
     *  2 => rouge   
     */
     public int  etatProduit ()  {
         
         int d  =  this.max -  this.min ; 
         int orange =  (d*35)/100  ; 
         
         if (this.quantite <= min ) {
             return 2  ;   
         }else{
             if (this.quantite <= orange) {
                 return  1  ; 
             } else {
                 return   0  ; 
             }
         }
         
     }
   
}
