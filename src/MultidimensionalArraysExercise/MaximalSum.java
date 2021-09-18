package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int[][] matrix = readMatrix(rows, scanner, " ");
        int[][] maxSubMatrix = getMaxSumSubMatrix4X4(matrix);
        System.out.print("Sum = ");
        System.out.println(getElementsSum(maxSubMatrix));
        printMatrix(maxSubMatrix);

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(splitPattern))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static int[][] getMaxSumSubMatrix4X4(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        int bestColTwo = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row][col + 2] + matrix[row + 1][col]
                        + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                    bestColTwo = col;
                }
            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow][bestCol + 2]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1], matrix[bestRow + 1][bestCol + 2]},
                {matrix[bestRow + 2][bestColTwo], matrix[bestRow + 2][bestColTwo + 1], matrix[bestRow + 2][bestColTwo + 2]}
        };
    }

    public static int getElementsSum(int[][] matrix) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
    }
}

