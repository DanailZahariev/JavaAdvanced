package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(",")[0]);
        String pattern = input.split(", ")[1];
        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix, n);
            printMatrix(matrix, n);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix, n);
            printMatrix(matrix, n);
        }
    }

    private static void fillMatrixPatternB(int[][] matrix, int n) {
        int startNum = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNum++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNum++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix, int n) {
        int startNum = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNum++;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
