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
    private final String absolute_path;
    private String file_name;
    private static Config instance = null;

        //Define the config.properties file path
        FileInputStream FIS;
        {
            try {
                FIS = new FileInputStream("D:\\Manik\\ServerTCP\\Server\\src\\ConfigFiles\\config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Properties prop;

        //Loading the config.properties file
        public Config() throws IOException {
        prop = new Properties();
        prop.load(FIS);
        FIS.close();
        //reading the element's content from config.properties
        port = Integer.parseInt(prop.getProperty("port"));
        absolute_path = new String(prop.getProperty("absolute_path"));
        file_name = new String(prop.getProperty("file_name"));
    }
    //Using Singleton method
        public static Config getInstance() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
       //---------------------------------------------------------------------//
        //Getters
        public int getPort(){return this.port;}

        public String getAbsolute_path(){return this.absolute_path;}

        public String getFile_name(){return this.file_name;}
}
