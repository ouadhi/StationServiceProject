package stationservice.model;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import stationservice.entity.Declaration;
import stationservice.ressource.SessionsGenerator;

public class DeclarationModel {

    public static boolean save(Declaration declaration) {
        System.out.println("---------began saving transaction Declaration");
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(declaration);
            session.getTransaction().commit();
            
            System.out.println("---------finished commiting transaction declaration");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            System.out.println("---------finished saving transaction declaration");
            return true;
        }
    }

    public static List<Declaration> getList() {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        List<Declaration> liste = new ArrayList<>();
        try {
            liste = session.createQuery("from Declaration").list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return liste;
    }
    
     public static Declaration getById(int id ) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        Declaration declaration  = new Declaration() ; 
        try {
            declaration = (Declaration)session.createQuery("from Declaration where id='"+id+"'").uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return declaration;
    }
     
     public static  Date getMaxDate () {
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        Date date = null ; 
       
        try {
            SQLQuery query  =  session.createSQLQuery("select max(date) from declaration") ; 
            List<Object>  liste =  query.list() ; 
            
            for (Object object : liste) {
             date  = (Date) object;                 
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            session.close();
            return date ; 
        }
        
        
       
     }

}
