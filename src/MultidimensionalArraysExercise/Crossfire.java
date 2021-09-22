package MultidimensionalArraysExercise;

import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(rows, cols, matrix);
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(command.split(" ")[0]);
            int col = Integer.parseInt(command.split(" ")[1]);
            int radius = Integer.parseInt(command.split(" ")[2]);
            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < rows) {
                    matrix[i][col] = 0;
                }
            }
            for (int i = col - radius; i <= col + radius; i++) {
                if (i >= 0 && i < cols) {
                    matrix[row][i] = 0;
                }
            }
            for (int i = col - radius; i <= col + radius; i++) {
                if (i >= 0 && i < cols) {
                    matrix[row][i] = 0;
                }
            }
            command = scanner.nextLine();
        }
    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        int start = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = start++;
            }
        }
    }

}
