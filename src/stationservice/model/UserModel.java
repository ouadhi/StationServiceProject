package stationservice.model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import stationservice.entity.User;
import stationservice.ressource.SessionsGenerator;

public class UserModel {

    public static boolean save(User user) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static List<User> getList() {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        List<User> liste = new ArrayList<>();
        try {
            liste = session.createQuery("from User").list();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return liste;
    }

    public static User getByName(String name) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        User user = null;
        try {
            user = (User) session.createQuery("from User where username ='" + name + "'").uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public static boolean delete(User user) {

        SessionsGenerator FactoryObject = new SessionsGenerator();
        Session session = SessionsGenerator.getFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
    }

    public static boolean connecte(User u) {
        User user = getByName(u.getUsername());
        if (user == null) {
            return false;
        } else {
            if (user.getPassword().equals(u.getPassword()) && user.isActive()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isexiste(String username ) {
        User u = getByName(username);
        if (u == null) {
            return false;
        } else {
            return true;
        }
    }

}
