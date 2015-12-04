package javase01.t05;

import java.util.Scanner;

public class UnitMatrix {

    public static void main(String[] args) {
        System.out.println(unitMatrix(readMatrixSize()));
    }

    private static int readMatrixSize() {

        System.out.println("Enter size of matrix");

        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Bad input");
        }
        return -1;
    }

    private static Matrix unitMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i == j || i + j == n - 1) ? 1 : 0;
            }
        }
        return new Matrix(matrix);
    }

    private static class Matrix {
        int[][] value;

        Matrix(int[][] value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    sb.append(value[i][j]);
                    sb.append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }

    }

}
