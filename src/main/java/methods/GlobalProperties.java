package methods;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import static methods.Constants.CONFIGPATH;

public class GlobalProperties {
    private Map<String, String> configProperties;
    private Properties properties = new Properties();
    InputStream inputStream = null;
    private static GlobalProperties globalProperties = null;

    //To read all property values from cucumber.properties file and store it in a map
    private GlobalProperties() {
        try {
            inputStream = new FileInputStream(CONFIGPATH);
            properties.load(inputStream);
            configProperties=(Map) properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //To create and return GlobalProperties type object to access getProperty method
    public static GlobalProperties getConfigProperties(){
        if(globalProperties==null)
        {
            globalProperties=new GlobalProperties();
        }
        return globalProperties;
    }

    //To read property values of cucumber.properties file from external .java file
    public String getProperty(String propertyName)
    {
        return configProperties.get(propertyName);
    }
}
