package stationservice.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import stationservice.entity.Bons;
import stationservice.entity.Declaration;
import stationservice.ressource.Methode;
import stationservice.ressource.SessionsGenerator;

public class BonsModel {

    public static boolean save(Bons bons) {
        System.out.println("---------began saving transaction Bons");
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(bons);
            session.getTransaction().commit();
            
            System.out.println("---------finished commiting transaction Bons");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            System.out.println("---------finished saving transaction Bons");
            return true;
        }
    }

    public static List<Bons> getList() {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        List<Bons> liste = new ArrayList<>();
        try {
            liste = session.createQuery("from Bons").list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return liste;
    }

    public static boolean delete(Bons bons) {
        System.out.println("---------began delete transaction Bons");
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(bons);
            session.getTransaction().commit();
            
            System.out.println("---------finished commiting transaction Bons");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            System.out.println("---------finished delete transaction Bons");
            return true;
        }
    }
    
     public static Bons getone(String d) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        Bons   bons  = null; 
        try {
            bons = (Bons) session.createQuery("from Bons where designation ='"+d+"'").uniqueResult() ; 
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bons ;
    }
     
     
    public static void proiduitExist (String designation  , Double valeur )  {
        if (getone(designation) != null) {
            System.out.println("Bons "+designation+" existe déjà ");    
        }else {
            Bons bons = new Bons();
            bons.setDateajoutbons(Methode.DateFormat(new Date()));
            bons.setDesignation(designation);
            bons.setVal(valeur);
            BonsModel.save(bons);
            System.out.println("creation du  Bonss" + designation );
        }
    }
    
    public static void testBons () {
        
        proiduitExist("bons1150", 1150.00);
        proiduitExist("bons850", 850.00);
        proiduitExist("bons839", 839.00);
        proiduitExist("bons690", 690.00);
        proiduitExist("bons416", 416.00);
        proiduitExist("bons332", 332.00);
       
    
    }

    
 
}
