package javase05.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesReader {

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        try {
            Properties properties = getProperties(askPropertiesFile());
            while (true) {
                getValue(properties);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Properties file does not exist");
            e.printStackTrace();
        }

    }


    public static void getValue(Properties properties) {
        String result = properties.getProperty(askPropertiesKey());
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

    public static Properties getProperties(File file) {

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}
