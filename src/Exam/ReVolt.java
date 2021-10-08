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
                playerWon = movePlayer(playerPosition, matrix);
            } else if (command.equals("down")) {

            } else if (command.equals("left")) {

            } else if (command.equals("right")) {

            }
        }
        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

    }

    private static boolean movePlayer(int[] playerPosition, char[][] matrix) {
        int row = playerPosition[0];
        int col = playerPosition[1];
        int newRow = row - 1;
        int newCol = col;
        boolean hasWon = false;
        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        } else if (matrix[newRow][newCol] == 'B') {
            newRow = row - 1;
            newCol = col;
        }
        matrix[newRow][newCol] = 'f';
        matrix[row][col] = '-';
        playerPosition[0] = newRow;
        playerPosition[1] = newCol;
        return hasWon;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.println(symbol);
            }
            System.out.println();
        }
    }
}
