package javase03.t03;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlChecker {

    private static final String FILENAME = "handling_task_attachment.html";
    private static final String PATTERN = "<img(\"[^\"]*\"|'[^']*'|[^'\">])*>.";


    public static void main(String[] args) throws IOException, URISyntaxException {

        String filePath = getPathForFileInResources(FILENAME);
        String text = readFile(filePath, Charset.defaultCharset());
        find(PATTERN, text);

    }

    private static String getPathForFileInResources(String fileName) throws URISyntaxException {
        HtmlChecker obj = new HtmlChecker();
        ClassLoader classLoader = obj.getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).toURI()).toString();
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    static void find(String pattern, String text) {

        Pattern r = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = r.matcher(text);

        while (m.find()) {
            String codeGroup = m.group(0);
            System.out.println(codeGroup);
        }
    }


}
