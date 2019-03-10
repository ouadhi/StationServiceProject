
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
import javax.persistence.TemporalType;

@Entity
@Table(name = "pompiste")

public class Pompiste implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "dateajoutpompiste")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateajoutpompiste;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "datenes")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenes;
    
    @Column(name = "lieunais")
    private String lieunais;
    
    @Column(name = "adresse")
    private String adresse;
    
    @Column(name = "telephone")
    private String telephone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpompiste")
    private List<Declaration> declarationCollection;

    public Pompiste() {
    }

    public Pompiste(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Date getDateajoutpompiste() {
        return dateajoutpompiste;
    }

    public void setDateajoutpompiste(Date dateajoutpompiste) {
        this.dateajoutpompiste = dateajoutpompiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenes() {
        return datenes;
    }

    public void setDatenes(Date datenes) {
        this.datenes = datenes;
    }

    public String getLieunais() {
        return lieunais;
    }

    public void setLieunais(String lieunais) {
        this.lieunais = lieunais;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Declaration> getDeclarationCollection() {
        return declarationCollection;
    }

    public void setDeclarationCollection(List<Declaration> declarationCollection) {
        this.declarationCollection = declarationCollection;
    }

    @Override
    public String toString() {
        return "Pompiste{" + "id=" + id + ", dateajoutpompiste=" + dateajoutpompiste + ", nom=" + nom + ", prenom=" + prenom + ", datenes=" + datenes + ", lieunais=" + lieunais + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
    
    
    
  
}
