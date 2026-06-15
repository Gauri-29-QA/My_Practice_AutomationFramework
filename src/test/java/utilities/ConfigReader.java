package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        String path =
                System.getProperty("user.dir")
                        + "/src/main/resources/config.properties";
        try {
            FileInputStream fis =
                    new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getUrl() {
        return prop.getProperty("url");
    }
}
