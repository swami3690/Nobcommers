import java.io.FileInputStream;
import java.util.Properties;

public class LoadProp {

    static Properties props;

    static FileInputStream inputStream;

    public String getProperty(String key) {

        props = new Properties();

        try {
            inputStream = new FileInputStream("src\\test\\Resource\\chromedriver.exe");
            props.load(inputStream);
            inputStream.close();


        } catch (java.io.IOException e) {
            e.printStackTrace();

        }
        return props.getProperty(key);


    }


}
