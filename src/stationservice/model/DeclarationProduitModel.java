
package stationservice.model;

import org.hibernate.Session;
import stationservice.entity.DeclarationProduit;
import stationservice.ressource.SessionsGenerator;


public class DeclarationProduitModel {
    
    public static boolean save (DeclarationProduit dp) {
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(dp);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }
}
