package javase01.t03;

import java.util.Scanner;

public class FunctionToTable {

    public static void main(String[] args) {
//        functionToTable(readInput());
        functionToTable(-1, 1, 0.1);
    }

    private static double[] readInput() {
        System.out.println("Enter endpoints of interval (a and b) and step h");

        Scanner scanner = new Scanner(System.in);
        return stringToDoubleArray(scanner.nextLine());
    }

    private static double[] stringToDoubleArray(String s) {

        //naive workaround for reading normally numbers with comma OR point as decimal separator
        String[] stringArgs = s.replaceAll(",", ".").split("\\s+");
        double[] doubleArgs = new double[stringArgs.length];

        try {
            for (int i = 0; i < stringArgs.length; i++) {
                doubleArgs[i] = Double.parseDouble(stringArgs[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad input");
        }
        return doubleArgs;
    }

    private static void functionToTable(double[] arguments) {
        double a = arguments[0];
        double b = arguments[1];
        double h = arguments[2];
        functionToTable(a, b, h);
    }

    private static void functionToTable(double a, double b, double h) {
        double x = a;
        while (x <= b) {
            System.out.printf("%.15f%20.15f%n", x, function(x));
            x += h;
        }

    }

    private static double function(double x) {
        return Math.tan(2 * x) - 3;
    }

}
