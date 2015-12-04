package javase01.t04;

import java.util.Scanner;

public class FindMaxSumInArray {

    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 50, 6, 7, 8, 9, 0};
        System.out.println(findMaxSum(readInput()));
    }


    private static double[] readInput() {

        System.out.println("Enter n (size of array = 2n) and elements of the array");

        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int size = 2 * n;
            double[] arguments = new double[size];
            int element = 0;
            while (element < size) {
                arguments[element] = scanner.nextDouble();
                element++;
            }
            return arguments;
        } catch (Exception e) {
            System.out.println("Bad input");
        }
        return null;
    }

    private static double findMaxSum(double[] array) {
        int n = array.length / 2;

        int j = array.length - 1;

        double max = Double.MIN_VALUE;

        for (int i = 0; i < n; i++, j--) {
            double sum = array[i] + array[j];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
