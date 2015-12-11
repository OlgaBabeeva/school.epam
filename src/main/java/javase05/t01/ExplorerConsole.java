package javase05.t01;

import java.io.File;
import java.util.Scanner;

public class ExplorerConsole {

    private static final String CD = "CD";
    private static final String NTF = "NTF";
    private static final String ATF = "ATF";
    private static final String DTF = "DTF";
    private static final String EXIT = "EXIT";

    public static void main(String[] args) {

        while (true) {
            getAction();
        }

    }

    private static File getFile() {
        File startFile;
        do {
            askFilePath();
            startFile = readFilePath();
        } while (!startFile.exists());
        return startFile;
    }


    private static File getTextFile() {
        File startFile;
        do {
            askTextFilePath();
            startFile = readFilePath();
        } while (!(startFile.exists() && SimpleFileExplorer.isTextFile(startFile)));
        return startFile;
    }

    private static void askFilePath() {
        System.out.println("Enter file path or " + EXIT);
    }

    private static void askTextFilePath() {
        System.out.println("Enter TEXT file path or " + EXIT);
    }

    private static File readFilePath() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext(EXIT)) {
            System.exit(0);
        }
        return new File(scanner.next());
    }

    private static void askAction() {
        System.out.println("Enter " + CD + " to explore file or folder");
        System.out.println("Enter " + NTF + " to create new text file");
        System.out.println("Enter " + ATF + " to add text to text file");
        System.out.println("Enter " + DTF + " to delete text file");
        System.out.println("Enter " + EXIT + " to stop");
    }

    private static void askTextToAppend() {
        System.out.println("Enter text to append to file, end with STOP");
    }

    private static String readTextToAppend() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            if (scanner.hasNext("STOP")) {
                break;
            }
            sb.append(scanner.nextLine());
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    private static void getAction() {
        askAction();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext(EXIT)) {
            System.exit(0);
        }
        switch (sc.next()) {

            case CD: {
                File file = getFile();
                SimpleFileExplorer.showFile(file);
                break;
            }
            case NTF: {
                askFilePath();
                File file = readFilePath();
                SimpleFileExplorer.createTextFile(file);
                break;
            }
            case ATF: {
                File file = getTextFile();
                askTextToAppend();
                SimpleFileExplorer.appendToTextFile(readTextToAppend(), file);
                break;
            }
            case DTF: {
                File file = getTextFile();
                SimpleFileExplorer.deleteTextFile(file);
                break;
            }
            default: {
                System.out.println("Try again");
            }

        }
    }

}

