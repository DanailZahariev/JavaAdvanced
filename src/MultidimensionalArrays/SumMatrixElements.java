package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(rows, cols, scanner, ", ");

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));
    }

    public static int getElementsSum(int[][] matrix) {
       /* int sum = 0;
        for (int[] array : matrix) {
            for (int element : array) {
                sum += element;
            }
        }*/
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }

    public static int[] readArray(String elements, String pattern) {
        return Arrays.stream(elements.split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }
}

