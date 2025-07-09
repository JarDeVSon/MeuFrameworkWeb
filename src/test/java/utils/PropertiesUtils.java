package utils;

import java.util.Properties;

public class PropertiesUtils {

    Properties properties = new Properties();

    public String getProperty(String key) {
        try{
            if (System.getProperty("env") == null){
                properties.load(getClass().getClassLoader().getResourceAsStream("dev.properties"));
            } else {
                properties.load(getClass().getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}