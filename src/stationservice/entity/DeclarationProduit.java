package stationservice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "declarationproduit")
public class DeclarationProduit implements Serializable {

    private static final long serialVerssionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "prix")
    private double prix;

    @Column(name = "nouveau")
    private int nouveau;

    @Column(name = "ancien")
    private int ancien;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "somme")
    private double somme;
    
    @JoinColumn(name = "iddeclaration", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Declaration iddeclaration;
     
    @JoinColumn(name = "idproduit", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produit idproduit;

    public DeclarationProduit(double prix, int nouveau, int ancien, int quantite, double somme, Declaration iddeclaration, Produit idproduit) {
        this.prix = prix;
        this.nouveau = nouveau;
        this.ancien = ancien;
        this.quantite = quantite;
        this.somme = somme;
        this.iddeclaration = iddeclaration;
        this.idproduit = idproduit;
        
    }

    public DeclarationProduit() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNouveau() {
        return nouveau;
    }

    public void setNouveau(int nouveau) {
        this.nouveau = nouveau;
    }

    public int getAncien() {
        return ancien;
    }

    public void setAncien(int ancien) {
        this.ancien = ancien;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public Declaration getIddeclaration() {
        return iddeclaration;
    }

    public void setIddeclaration(Declaration iddeclaration) {
        this.iddeclaration = iddeclaration;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

}
