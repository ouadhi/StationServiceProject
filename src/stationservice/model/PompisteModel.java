package stationservice.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import stationservice.entity.Pompiste;
import stationservice.ressource.SessionsGenerator;

public class PompisteModel {

    public static boolean save(Pompiste pompiste) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(pompiste);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static List<Pompiste> getList() {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        List<Pompiste> liste = new ArrayList<>();
        try {
            liste = session.createQuery("from Pompiste").list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return liste;
    }

    public static boolean delete(Pompiste pompiste) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(pompiste);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static Pompiste getPompisteById(int id) {
        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        Pompiste pompiste = null;
        try {
            pompiste = (Pompiste) session.createQuery("from Pompiste where id='" + id + "'").uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pompiste;
    }

    public static ArrayList<String> pompiste_nom_prenom() {
        ArrayList<String> list = new ArrayList<String>();

        for (Pompiste pompiste : getList()) {
            String item = pompiste.getNom() + "-" + pompiste.getPrenom();
            list.add(item);
        }
        return list;
    }

    public static Pompiste get_pompist_by_nom_prenom(String nom, String prenom) {

        Pompiste pompiste = null;
        try {
            SessionsGenerator FactoryObject = new SessionsGenerator();
            Session session = SessionsGenerator.getFactory().openSession();
            pompiste = (Pompiste) session.createQuery("from Pompiste where nom='" + nom + "' and prenom ='" + prenom + "'").uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pompiste;
    }

}
