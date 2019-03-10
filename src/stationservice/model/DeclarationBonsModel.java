
package stationservice.model;

import org.hibernate.Session;
import stationservice.entity.Decbons;
import stationservice.ressource.SessionsGenerator;


public class DeclarationBonsModel {
    
    public static boolean save (Decbons db) {
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            
            session.beginTransaction();
            session.saveOrUpdate(db);
            session.getTransaction().commit();
            
            session.close();
            
            return  true ; 

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
      
}
