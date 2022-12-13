package commonmethods;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YAMLReader {

    private Map<String, String> ymlData;

    private Map<String, Map<String, String>> ymlInputDataSet;

    public YAMLReader(String fileName) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(fileName);
        try {
            if (fileName.contains("pageobject"))
                ymlData = yaml.loadAs(inputStream, Map.class);
            else if (fileName.contains("Environments"))
                ymlData = yaml.loadAs(inputStream, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getYmlData() {
        return ymlData;
    }

}
