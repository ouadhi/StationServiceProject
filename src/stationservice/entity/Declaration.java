package stationservice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "declaration")
public class Declaration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;
    
     @Column(name = "date2")
    private Date date2;

    @Column(name = "total")
    private double total;

    @Column(name = "bons")
    private double bons;

    @Column(name = "billets")
    private double billets;

    @Column(name = "debut_job")
    private String debut_job;

    @Column(name = "fin_job")
    private String fin_job;
    
     @Column(name = "debut_job2")
    private String debut_job2;

    @Column(name = "fin_job2")
    private String fin_job2;
    
    @Column(name = "avance")
    private double avance;

    @JoinColumn(name = "idpompiste", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pompiste idpompiste;
    
    @JoinColumn(name ="iduser" , referencedColumnName = "id" )
    @ManyToOne(optional = false)
    private  User  iduser  ;  

    @OneToMany(targetEntity = Decbons.class, mappedBy = "iddeclaration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Decbons> decbonsCollection = new ArrayList<>();

    @OneToMany(targetEntity = DeclarationProduit.class, mappedBy = "iddeclaration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<DeclarationProduit> declarationProduits = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBons() {
        return bons;
    }

    public void setBons(double bons) {
        this.bons = bons;
    }

   

    public List<Decbons> getDecbonsCollection() {
        return decbonsCollection;
    }

    public void setDecbonsCollection(List<Decbons> decbonsCollection) {
        this.decbonsCollection = decbonsCollection;
    }

    public double getBillets() {
        return billets;
    }

    public void setBillets(double billets) {
        this.billets = billets;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public String getDebut_job() {
        return debut_job;
    }

    public void setDebut_job(String debut_job) {
        this.debut_job = debut_job;
    }

    public String getFin_job() {
        return fin_job;
    }

    public void setFin_job(String fin_job) {
        this.fin_job = fin_job;
    }

    public Pompiste getIdpompiste() {
        return idpompiste;
    }

    public void setIdpompiste(Pompiste idpompiste) {
        this.idpompiste = idpompiste;
    }

    public List<DeclarationProduit> getDeclarationProduits() {
        return declarationProduits;
    }

    public void setDeclarationProduits(List<DeclarationProduit> declarationProduits) {
        this.declarationProduits = declarationProduits;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDebut_job2(String debut_job2) {
        this.debut_job2 = debut_job2;
    }

    public String getDebut_job2() {
        return debut_job2;
    }

    public void setFin_job2(String fin_job2) {
        this.fin_job2 = fin_job2;
    }

    public String getFin_job2() {
        return fin_job2;
    }
}
