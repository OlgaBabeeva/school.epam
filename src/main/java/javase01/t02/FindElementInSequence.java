package javase01.t02;

import java.util.Scanner;

public class FindElementInSequence {

    public static void main(String[] args) {
        findFirstElementLessThanEpsilon(readValueToSearch());
    }

    private static double readValueToSearch() {
        System.out.println("Enter searched value");

        try {
            Scanner scanner = new Scanner(System.in);
            //naive workaround for reading normally numbers with comma OR point as decimal separator
            String eps = scanner.next().replaceAll(",", ".");
            return Double.valueOf(eps);

        } catch (NumberFormatException e) {
            System.out.println("Bad input");
        }
        return Double.MAX_VALUE;
    }


    private static void findFirstElementLessThanEpsilon(double epsilon) {

        StringBuilder sb = new StringBuilder();

        int numberOfElement = 0;

        double a = Double.MAX_VALUE;

        while (a >= epsilon) {

            numberOfElement++;

            a = Math.pow(numberOfElement + 1, -2);

            sb.append(a);
            sb.append("\n");
        }

        System.out.println("First element of sequence less than " + epsilon +
                " has number " + numberOfElement);
        System.out.println(sb.toString());
    }

}

