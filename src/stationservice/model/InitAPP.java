
package stationservice.model;

import org.hibernate.Session;
import stationservice.ressource.SessionsGenerator;


public class InitAPP {

    public InitAPP() {
    }
    
    public void  doInit() {
        try {
             SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        
        
                
        } catch (Exception e) {
        }
    }
    
}
