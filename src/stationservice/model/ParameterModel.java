
package stationservice.model;

import org.hibernate.Session;
import stationservice.ressource.SessionsGenerator;
import stationservice.entity.Parametre ; 


public class ParameterModel {
    
    
   public static  Parametre getparametre  () {
       Session   session  =   SessionsGenerator .getFactory().openSession() ; 
       Parametre   parametre   = null ;
       try {
           parametre = (Parametre)  session.createQuery("FROM Parametre ").uniqueResult(); 
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       finally{
           session.close();
           return   parametre ; 
       }
   } 
    
}
