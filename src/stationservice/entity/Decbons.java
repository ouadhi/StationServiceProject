package stationservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import stationservice.ressource.Methode;
import sun.security.jgss.spi.MechanismFactory;

@Entity
@Table(name = "decbons")

public class Decbons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @Column(name = "nbons")
    private int nbons;

    @Column(name = "total")
    private double total;

    @JoinColumn(name = "iddeclaration")
    @ManyToOne(optional = false)
    private Declaration iddeclaration;

    @JoinColumn(name = "idbons")
    @ManyToOne(optional = false)
    private Bons idbons;

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

    public int getNbons() {
        return nbons;
    }

    public void setNbons(int nbons) {
        this.nbons = nbons;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Declaration getIddeclaration() {
        return iddeclaration;
    }

    public void setIddeclaration(Declaration iddeclaration) {
        this.iddeclaration = iddeclaration;
    }

    public Bons getIdbons() {
        return idbons;
    }

    public void setIdbons(Bons idbons) {
        this.idbons = idbons;
    }

    public Decbons(Date date , int nbons, double total, Declaration iddeclaration, Bons idbons) {
        this.date = date  ; 
        this.nbons = nbons;
        this.total = total;
        this.iddeclaration = iddeclaration;
        this.idbons = idbons;
    }

    public Decbons() {
    }
    

}
