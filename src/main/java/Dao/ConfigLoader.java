package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE = "config.properties";

    public static Properties loadConfig(){
        Properties properties = new Properties();
        try{
            File file = new File(CONFIG_FILE);
            FileInputStream input = new FileInputStream(file);
            properties.load(input);
            input.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se encuentra la configuración");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al leer la configuración");
        }
        return properties;
    }
    
}

