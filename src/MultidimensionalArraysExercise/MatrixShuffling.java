package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        fillMatrix(scanner, matrix, rows, cols);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (!validCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String[] tokes = command.split(" ");
                int firstRow = Integer.parseInt(tokes[1]);
                int firstCol = Integer.parseInt(tokes[2]);
                int secondRow = Integer.parseInt(tokes[3]);
                int secondCol = Integer.parseInt(tokes[4]);
                String elementOne = matrix[firstRow][firstCol];
                String elementTwo = matrix[secondRow][secondCol];
                matrix[firstRow][firstCol] = elementTwo;
                matrix[secondRow][secondCol] = elementOne;
                printMatrix(matrix, rows, cols);
            }
            command = scanner.nextLine();
        }

    }

    private static boolean validCommand(String command, int rows, int cols) {
        String[] tokes = command.split(" ");
        String commandName = tokes[0];
        if (!commandName.equals("swap")) {
            return false;
        }
        if (tokes.length != 5) {
            return false;
        }
        int firstRow = Integer.parseInt(tokes[1]);
        int firstCol = Integer.parseInt(tokes[2]);
        int secondRow = Integer.parseInt(tokes[3]);
        int secondCol = Integer.parseInt(tokes[4]);
        if (firstRow < 0 || firstRow >= rows || firstCol < 0 || firstCol >= cols || secondRow < 0
                || secondRow >= rows || secondCol < 0 || secondCol >= cols) {
            return false;
        }
        return true;
    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (String[] array : matrix) {
            for (String elements : array) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }
}
