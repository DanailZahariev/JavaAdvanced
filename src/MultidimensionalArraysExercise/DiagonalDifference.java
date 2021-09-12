package MultidimensionalArraysExercise;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(matrix, size, scanner);
        System.out.println(Math.abs(getSumPrimary(matrix, size) - getSumSecondary(matrix, size)));

    }

    private static int getSumSecondary(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) == (size - 1)) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int getSumPrimary(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, int size, Scanner scanner) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
