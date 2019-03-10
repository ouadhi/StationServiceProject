
package stationservice.ressource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import stationservice.entity.Bons;
import stationservice.entity.Decbons;
import stationservice.entity.Declaration;
import stationservice.entity.DeclarationProduit;
import stationservice.entity.Pompiste;
import stationservice.entity.Produit;
import stationservice.entity.User;



public class SessionsGenerator {
    // class singleton pour generer les sessions,

    static SessionFactory factory = null;
    static int singletonCounter = 0;

    public static SessionFactory getFactory() {
        return factory;
    }

    public SessionsGenerator() {

        if (singletonCounter == 0) {
            // create singleton factory object
            Configuration configuration = new Configuration().configure("/stationservice/ressource/hibernate.cfg.xml")
            //Configuration configuration = new Configuration().configure("/resources/hibernatep.cfg.xml")
                   .addAnnotatedClass(Bons.class)
                   .addAnnotatedClass(Decbons.class)
                    .addAnnotatedClass(Produit.class)
                    .addAnnotatedClass(Declaration.class)
                    .addAnnotatedClass(DeclarationProduit.class)
                    .addAnnotatedClass(Pompiste.class) 
                    .addAnnotatedClass(User.class); 
                   
  
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(builder.build());
            singletonCounter++;
        }
    }
}
