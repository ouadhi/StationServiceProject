package stationservice.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import stationservice.entity.Bons;
import stationservice.model.BonsModel;
import stationservice.model.DeclarationModel;
import stationservice.report.GenerateReport;
import stationservice.ressource.Methode;

public class Main {

    public static void main(String[] args) {
        try {
            String fileName = "/stationservice/ressource/etatup.pdf";
            ClassLoader  classLoader  =  ClassLoader.getSystemClassLoader() ;
            
            File file = new  File(classLoader.getResource(fileName).toURI()) ;
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
