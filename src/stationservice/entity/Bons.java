
package stationservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "bons")
public class Bons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "dateajoutbons")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateajoutbons;
    
    @Column(name = "val")
    private double val;
    
    @Column(name = "designation")
    private String designation;
    
    @OneToMany(targetEntity = Decbons.class, mappedBy = "idbons", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Decbons> decbonsCollection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateajoutbons() {
        return dateajoutbons;
    }

    public void setDateajoutbons(Date dateajoutbons) {
        this.dateajoutbons = dateajoutbons;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public List<Decbons> getDecbonsCollection() {
        return decbonsCollection;
    }

    public void setDecbonsCollection(List<Decbons> decbonsCollection) {
        this.decbonsCollection = decbonsCollection;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Bons{" + "id=" + id + ", dateajoutbons=" + dateajoutbons + ", val=" + val + ", designation=" + designation + ", decbonsCollection=" + decbonsCollection + '}';
    }
    
    
    
    
    
}
