package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class uses Singleton method and has a connection to config.properties file
 */
public class Config {

    private final int port;
    private static Config instance = null;

        //Define the config.properties file path
        FileInputStream FIS;
        {
            try {
                FIS = new FileInputStream("Server/src/ConfigFiles/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Properties prop;

        //Loading the config.properties file
        private Config () throws IOException {
        prop = new Properties();
        prop.load(FIS);
        FIS.close();
        port = Integer.parseInt(prop.getProperty("port"));
    }
    //Using Singleton method
        public static Config getInstance() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
        //Getters for strings
        public int getPort(){return this.port;}

}
