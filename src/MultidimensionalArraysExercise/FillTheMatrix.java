package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int size = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];
        int[][] matrix = new int[size][size];
        if (pattern.equals("A")) {
            fillMatrixA(matrix, size);
        } else if (pattern.equals("B")) {
            fillMatrixB(matrix, size);
        }
        printMatrix(matrix, size, size);
    }

    public static void fillMatrixA(int[][] matrix, int size) {
        int start = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = start++;
            }
        }
    }

    public static void fillMatrixB(int[][] matrix, int size) {
        int start = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = start++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = start++;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int[] array : matrix) {
            for (int elements : array) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
       /* for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.println(matrix[row][col] + " ");
            }
            System.out.println();
        }*/
    }
}
