package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties  prop = new Properties ();
    private FileInputStream inputStream = null;

    public PropertiesReader(){
        try{
            String filePath =System.getProperty("user.dir")+"/src/test/resources/config.properties";
            inputStream = new FileInputStream(filePath);
            prop.load(inputStream);

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public String getBaseUrl(){
        return prop.getProperty("baseUrl");

    }

    public String getUser(String user){
        return prop.getProperty(user);

    }

    public String getPages(){
        return prop.getProperty("pages");

    }

    public String getContentYpe(){
        return prop.getProperty("contentType");

    }


}
