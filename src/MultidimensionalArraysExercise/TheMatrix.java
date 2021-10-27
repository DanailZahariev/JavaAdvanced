package MultidimensionalArraysExercise;

import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] matrix = readMatrix(scanner, rows, cols);
        char replaceChar = scanner.nextLine().charAt(0);

        String[] startingPoint = scanner.nextLine().split(" ");
        int startRow = Integer.parseInt(startingPoint[0]);
        int startCol = Integer.parseInt(startingPoint[1]);
        char startingChar = matrix[startRow][startCol];

        fillMatrixWithChar(startRow, startCol, replaceChar, startingChar, matrix);

        printMatrix(matrix);
    }


    private static void fillMatrixWithChar(int startRow, int startCol, char fillChar, char startChar, char[][] matrix) {
        if (matrix[startRow][startCol] != startChar) {
            return;
        }
        matrix[startRow][startCol] = fillChar;
        if (startRow - 1 >= 0) {
            fillMatrixWithChar(startRow - 1, startCol, fillChar, startChar, matrix);
        }
        if (startRow + 1 < matrix.length) {
            fillMatrixWithChar(startRow + 1, startCol, fillChar, startChar, matrix);
        }
        if (startCol - 1 >= 0) {
            fillMatrixWithChar(startRow, startCol - 1, fillChar, startChar, matrix);
        }
        if (startCol + 1 < matrix[startRow].length) {
            fillMatrixWithChar(startRow, startCol + 1, fillChar, startChar, matrix);
        }
    }

    static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                char currentSymbol = elements[col].charAt(0);
                matrix[row][col] = currentSymbol;
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
