package javase04.t02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static javase04.t01.KeyWords.countJavaKeywords;

public class CountJavaKeywordsChar {

    private static final String DEFAULT_OUTPUT_FILE_NAME = "java keywords count CHAR.txt";

    public static void countKeywordsAndWriteToFile(String fileToCountPath, String outputFilePath) throws IOException {
        String fileContent = new String(getCharsFromFile(fileToCountPath));
        stringToFile(countJavaKeywords(fileContent).toString(), outputFilePath);
    }

    public static void countKeywordsAndWriteToFile(String fileToCountPath) throws IOException {
        countKeywordsAndWriteToFile(fileToCountPath, DEFAULT_OUTPUT_FILE_NAME);
    }

    private static char[] getCharsFromFile(String filePath) throws IOException {
        char[] charsFromFile;
        File f = new File(filePath);
        try (FileReader fileReader = new FileReader(f)) {
            charsFromFile = new char[(int) f.length()];
            fileReader.read(charsFromFile, 0, charsFromFile.length);
        }
        return charsFromFile;
    }

    private static void stringToFile(String content, String fileName) {
        char[] contentChars = content.toCharArray();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(contentChars);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
