package Exam;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandsCountLines = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int[] playerPosition = new int[2];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("f")) {
                playerPosition[0] = row;
                playerPosition[1] = line.indexOf("f");
            }
        }
        boolean playerWon = false;
        while (commandsCountLines-- > 0 && !playerWon) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                playerWon = movePlayer(playerPosition, matrix, -1, 0);
            } else if (command.equals("down")) {
                playerWon = movePlayer(playerPosition, matrix, +1, 0);
            } else if (command.equals("left")) {
                playerWon = movePlayer(playerPosition, matrix, 0, -1);
            } else if (command.equals("right")) {
                playerWon = movePlayer(playerPosition, matrix, 0, +1);
            }
        }
        if (playerWon) {
            System.out.println("Player won!");
            printMatrix(matrix);
        } else {
            System.out.println("Player lost!");
            printMatrix(matrix);
        }

    }

    private static boolean movePlayer(int[] playerPosition, char[][] matrix, int rowModification, int colModification) {
        int row = playerPosition[0];
        int col = playerPosition[1];
        int newRow = ensureIndexisInBounds(row + rowModification, matrix.length);
        int newCol = ensureIndexisInBounds(col + colModification, matrix.length);
        boolean hasWon = false;
        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        } else if (matrix[newRow][newCol] == 'B') {
            newRow = ensureIndexisInBounds(newRow + rowModification, matrix.length);
            newCol = ensureIndexisInBounds(newCol + colModification, matrix.length);
            if (matrix[newRow][newCol] == 'F') {
                hasWon = true;
            }
        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;

        }
        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        playerPosition[0] = newRow;
        playerPosition[1] = newCol;
        return hasWon;
    }

    private static int ensureIndexisInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }
        return index;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
