package javase05.t01;

import net.sf.jmimemagic.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SimpleFileExplorer {


    public static void showFile(File file) {
        if (file.isDirectory()) {
            List<String> contents = Arrays.asList(file.list());
            for (String content : contents) {
                File subDirectory = new File(file, content);
                if (!subDirectory.isDirectory()) {
                    System.out.println(content);
                } else {
                    System.out.println("{folder} " + content);
                }
            }
        } else {
            System.out.println(file);
        }
    }

    public static void createTextFile(File file) {
        if (file.exists()) {
            System.out.println("file already exists");
            return;
        }
        try {
            file.createNewFile();
            System.out.println(file + " created");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void appendToTextFile(String textToAppend, File file) {
        if (!isTextFile(file)) {
            System.out.println("You can add text only to text files.");
            return;
        }

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            out.print(textToAppend);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTextFile(File file) {
        if (isTextFile(file)) {
            file.delete();
        } else {
            System.out.println("You can delete only text files.");
        }
    }

    //naive check for text files
    public static boolean isTextFile(File file) {
        String fileName = file.getName();
        return fileName.endsWith(".txt");
    }


}
