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
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id ; 
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column (name= "dateajoute") 
    @Temporal(TemporalType.DATE)
    private Date dateajoute ; 
    
    @Column(name = "privilege")
    private String privilege;
    
    @Column(name ="active")
    private  boolean active  ; 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private  List<Declaration>  declarations  ;  

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateajoute() {
        return dateajoute;
    }

    public void setDateajoute(Date dateajoute) {
        this.dateajoute = dateajoute;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<Declaration> declarations) {
        this.declarations = declarations;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", dateajoute=" + dateajoute + ", privilege=" + privilege + ", active=" + active + '}';
    }

}
