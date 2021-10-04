package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rows, 0, scanner, "\\s+");
        int[] coordinates = readArray(scanner.nextLine(), "\\s+");
        int wrongValue = matrix[coordinates[0]][coordinates[1]];
        List<int[]> updatedValues = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    updatedValues.add(new int[]{row, col, getClosestItemSum(row, col, matrix, wrongValue)});
                }
            }
        }
        for (int[] updatedValue : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);
    }

    private static int getClosestItemSum(int row, int col, int[][] matrix, int wrongValue) {
        int sum = 0;
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1]; //right
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1]; // left
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col]; // down
        }
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col]; // up
        }
        return sum;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }

    public static int[] readArray(String elements, String pattern) {
        return Arrays.stream(elements.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        return !isInBounds(row, col, matrix);
    }
}
