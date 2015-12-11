package javase04.t01;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static javase04.t01.KeyWords.countJavaKeywords;

public class CountJavaKeywordsByte {

    private static final String DEFAULT_OUTPUT_FILE_NAME = "java keywords count BYTE.txt";

    public static void countKeywordsAndWriteToFile(String fileToCountPath, String outputFilePath) throws IOException {
        String fileContent = new String(getBytesFromFile(fileToCountPath));
        stringToFile(countJavaKeywords(fileContent).toString(), outputFilePath);
    }

    public static void countKeywordsAndWriteToFile(String fileToCountPath) throws IOException {
        countKeywordsAndWriteToFile(fileToCountPath, DEFAULT_OUTPUT_FILE_NAME);
    }

    private static byte[] getBytesFromFile(String filePath) throws IOException {
        try (FileInputStream in = new FileInputStream(filePath);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = in.read(buffer)) != -1; ) {
                os.write(buffer, 0, len);
            }
            os.flush();
            return os.toByteArray();
        }
    }


    private static void stringToFile(String content, String fileName) {
        byte[] contentBytes = content.getBytes();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(contentBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
