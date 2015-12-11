package javase03.t02;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Eliza {

    private Locale locale;

    private ResourceBundle questionsBundle;
    private ResourceBundle answersBundle;
    private ResourceBundle promptsBundle;

    private static final int FIRST_QUESTION = 1;
    private static final int LAST_QUESTION = 3;

    private static final int BAD_NUMBER = 0;
    private static final int EXIT_CODE = -1;

    private static final Locale enLocale = Locale.forLanguageTag("EN");
    private static final Locale ruLocale = Locale.forLanguageTag("RU");

    private static final ResourceBundle engLangBundle = ResourceBundle.getBundle("prompts", enLocale);
    private static final ResourceBundle ruLangBundle = ResourceBundle.getBundle("prompts", ruLocale);


    public static void main(String[] args) {
        askLanguage();
        Eliza eliza = new Eliza(readLanguage());
        eliza.printQuestions();
        eliza.manageAnswers();
    }

    private static void askLanguage() {
        System.out.println(engLangBundle.getString("askLanguage"));
        System.out.println(ruLangBundle.getString("askLanguage"));
    }

    public Eliza(Locale locale) {
        this.locale = locale;
        questionsBundle = ResourceBundle.getBundle("questions", locale);
        answersBundle = ResourceBundle.getBundle("answers", locale);
        promptsBundle = ResourceBundle.getBundle("prompts", locale);
    }


    public void printQuestions() {
        for (int i = FIRST_QUESTION; i <= LAST_QUESTION; i++) {
            System.out.println(i + ": " + questionsBundle.getString("" + i));
        }
    }

    public void manageAnswers() {
        while (true) {
            suggestAnswers();
            int number = readQuestionNumbers();
            if (number == EXIT_CODE) {
                return;
            }
            if (validQuestionNumber(number)) {
                printAnswer(number);
            } else {
                notifyAboutBadInput();
            }
        }
    }


    public void suggestAnswers() {
        System.out.println(promptsBundle.getString("answersPrompt"));
    }
    public void notifyAboutBadInput() {System.out.println(promptsBundle.getString("badInput"));}

    private int readQuestionNumbers() {
        Scanner sc = new Scanner(System.in);
        try {
            //no sense in making escape prompt not fixed because it is hardcoded in resources - no easy way to change it
            if (sc.hasNext("EXIT")) {
                return EXIT_CODE;
            }
            return  sc.nextInt();
        } catch (NoSuchElementException e) {
            return BAD_NUMBER;
        }
    }

    private static Locale readLanguage() {
        Scanner scanner = new Scanner(System.in);
        String language = scanner.next();

        switch (language) {
            case "EN": {
                return enLocale;
            }
            case "RU": {
                return ruLocale;
            }
            case "EXIT": {
                System.exit(0);
            }
            default: {
                System.out.println(engLangBundle.getString("badInput"));
                System.out.println(ruLangBundle.getString("badInput"));
            }
        }
        return readLanguage();
    }


    public void printAnswer(int i) {
        System.out.println(i + ": " + answersBundle.getString("" + i));
    }


    private static boolean validQuestionNumber(int number) {
        return number >= FIRST_QUESTION && number <= LAST_QUESTION;
    }
}
