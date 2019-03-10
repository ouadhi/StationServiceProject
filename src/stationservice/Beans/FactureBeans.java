
package stationservice.Beans;


public class FactureBeans {
     private String nom_entreprise  ; 
     private String adresse ; 
     private String telephone  ; 

    public FactureBeans() {
    }

    public FactureBeans(String nom_entreprise, String adresse, String telephone) {
        this.nom_entreprise = nom_entreprise;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
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
     
     
}
