package javase06.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesReaderMap {

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        try {
            Map<String, String> properties = getProperties(askPropertiesFile());
            while (true) {
                getValue(properties);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Properties file does not exist");
            e.printStackTrace();
        }

    }


    public static void getValue(Map<String, String> propertiesMap) {
        String result = propertiesMap.get(askPropertiesKey());
        System.out.println(result != null ? result : "No such key in properties file");
    }

    public static File askPropertiesFile() throws FileNotFoundException {
        System.out.println("Enter path properties file");
        Scanner scanner = new Scanner(System.in);
        return checkFile(scanner.next());
    }

    public static File checkFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (file.exists()) {
            return file;
        } else {
            throw new FileNotFoundException();
        }
    }

    public static String askPropertiesKey() {
        System.out.println("Enter key");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static Map<String, String> getProperties(File file) {

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertiesToMap(prop);
    }

    public static Map<String, String> propertiesToMap(Properties properties) {
        Map<String, String> propertiesMap = new HashMap<>();
        for (final String name : properties.stringPropertyNames()) {
            propertiesMap.put(name, properties.getProperty(name));
        }
        return propertiesMap;
    }
}
