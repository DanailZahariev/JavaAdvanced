package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(rows, cols, scanner, ", ");
        int[][] maxSubMatrix = getMaxSumSubMatrix2X2(matrix);
        printMatrix(maxSubMatrix);
        System.out.println(getElementsSum(maxSubMatrix));


      /*  System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1]);
        System.out.println(maxSum);*/
    }

    public static int[][] getMaxSumSubMatrix2X2(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }

    public static int[] readArray(String elements, String pattern) {
        return Arrays.stream(elements.split(pattern))
                .mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
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
}
