package stationservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import stationservice.entity.Produit;
import stationservice.ressource.SessionsGenerator;

public class ProduitModel {

    private static String str_super = "super";
    private static String str_sp1 = "sans plomb1";
    private static String str_sp2 = "sans plomb2";
    private static String str_gasoil = "gazoil";

    public static boolean save(Produit produit) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(produit);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static List<Produit> getList() {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        List<Produit> liste = new ArrayList<>();
        try {
            liste = session.createQuery("from Produit").list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return liste;
    }

    public static boolean delete(Produit produit) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(produit);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static Produit getById(int id) {
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        Produit produit = new Produit();
        try {
            produit = (Produit) session.createQuery("from Produit where id = '" + id + "'").uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return produit;

    }

    public static Produit getByDesignation(String designation) {
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        Produit produit = null ; 
        try {
            produit = (Produit) session.createQuery("from Produit where disignations = '" + designation + "'").uniqueResult();
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return produit;
    }

    public static Produit getSuper() {
        return getByDesignation(str_super);
    }
    
    public static Produit getSp1() {
        return getByDesignation(str_sp1);
    }
     
    public static Produit getSp2() {
        return getByDesignation(str_sp2);
    }
      
    public static Produit getGasoil() {
        return getByDesignation(str_gasoil);
    }
    
    
    private static void  exsiteProduit(String desgnation) {
        if (getByDesignation(desgnation) == null ) {
            // create  Produit 
            Produit produit  = new Produit() ;  
            produit.setCompteur(0);
            produit.setDisignations(desgnation);
            produit.setMax(20000);
            produit.setMin(1000);
            produit.setPrix(30);
            produit.setQuantite(1000);
            produit.setDate(new Date());
            
            save(produit)  ; 
            
            System.out.println("  creatio de   Produit "+desgnation);
        }else{
            System.out.println(" produit deja creer ");
        }
    }
    
    
    public static void testProduit () {
        
        exsiteProduit("sans plomb1");
        exsiteProduit("sans plomb2");
        exsiteProduit("super");
        exsiteProduit("gazoil");
        
    }
    
    

}
