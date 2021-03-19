package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static FileReader reader = null;
    private static final String propRoot = "src/main/resources/";
    private static final Properties p = new Properties();

    public static String getProperty(String propertyFileName, String propertyName) {
        String propPath = propRoot + propertyFileName;

        try {
            reader = new FileReader(propPath);
        } catch (FileNotFoundException e) {
            System.out.println("No file found in the given path: " + propPath);
            e.printStackTrace();
        }

        try {
            p.load(reader);
        } catch (IOException e) {
            System.out.println("Couldn't find any properties with the given property name: " + propertyName);
            e.printStackTrace();
        }

        return p.getProperty(propertyName);

    }
}
