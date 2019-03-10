package stationservice.propertie;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    Properties prop = new Properties();
    InputStream input = null;
    
    private String  company , address , phone ; 

    public Property() {
        initProprties();
    }

    private void initProprties() {
        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));
            System.out.println(prop.getProperty("company"));
            System.out.println(prop.getProperty("address"));
            System.out.println(prop.getProperty("phone"));
            
            this.company =  prop.getProperty("company") ;  
            this.address =  prop.getProperty("address") ; 
            this.phone  = prop.getProperty("phone") ; 
            
        
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String getPhone() {
        return phone;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }
    
    
}
