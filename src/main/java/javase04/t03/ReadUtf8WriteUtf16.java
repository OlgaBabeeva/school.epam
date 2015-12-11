package javase04.t03;

//��� ����, ���������� ����� ����� �� ���������. ��������� ����� utf-8. ����������
//���������� �� ����� � ���������� �� � ���� � ���������� utf-16.

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_16;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadUtf8WriteUtf16 {

    public static void readUtf8WriteUtf16(String fileFrom, String fileTo) {
        File outputFile = new File(fileTo);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileFrom), UTF_8));
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), UTF_16))) {

            String line;
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
