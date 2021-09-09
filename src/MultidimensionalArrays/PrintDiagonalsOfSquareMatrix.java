package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsAndCols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rowsAndCols][];
        readMatrix(scanner, rowsAndCols, matrix);
        for (int rowAndCol = 0; rowAndCol < rowsAndCols; rowAndCol++) {
            System.out.print(matrix[rowAndCol][rowAndCol] + " ");
        }
        System.out.println();
        int countRow = rowsAndCols -1;
        for (int col = 0; col < rowsAndCols; col++) {
            System.out.print(matrix[countRow][col] + " ");
            countRow--;
        }
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    public static void readMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            int[] array = readArray(scanner);
            matrix[i] = array;
        }
    }
}
