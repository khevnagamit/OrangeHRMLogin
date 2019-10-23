package OrangeHRMLogin;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProp {
    static Properties props;
    static FileInputStream inputStream;

    public String getProperties(String key){
        props = new Properties();

        try {
            inputStream = new FileInputStream("src\\test\\Resourses\\TestData\\TestDataConfig.properties");
            props.load(inputStream);
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return  props.getProperty(key);
    }
}
