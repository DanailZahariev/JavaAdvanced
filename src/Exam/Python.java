package Exam;

import java.util.Scanner;

public class Python {
    static int food = 0;
    static int pRow = 0;
    static int pCol = 0;
    static int length = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
            if (line.contains("s")) {
                pRow = row;
                pCol = line.indexOf("s");
            }
            for (char chars : matrix[row]) {
                if (chars == 'f') {
                    food++;
                }
            }
        }
        for (String command : commands) {
            if (command.equals("up")) {
                movePython(matrix, pRow - 1, pCol);
            } else if (command.equals("down")) {
                movePython(matrix, pRow + 1, pCol);
            } else if (command.equals("left")) {
                movePython(matrix, pRow, pCol - 1);
            } else if (command.equals("right")) {
                movePython(matrix, pRow, pCol + 1);
            }
            if (length == -1 || food == 0) {
                break;
            }
        }
        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
        } else if (food > 0 && length != -1) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }
    }

    private static void movePython(char[][] matrix, int newRow, int newCol) {
        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipSnakeSide(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }
        if (matrix[newRow][newCol] == 'e') {
            length = -1;
        } else if (matrix[newRow][newCol] == 'f') {
            length++;
            food--;
        }
        pRow = newRow;
        pCol = newCol;
    }

    private static int[] flipSnakeSide(int length, int row, int col) {
        int[] result = new int[2];
        if (row < 0) {
            result[0] = length - 1;
            result[1] = col;
        } else if (row >= length) {
            result[1] = col;
        } else if (col < 0) {
            result[0] = row;
            result[1] = length - 1;
        } else {
            result[0] = row;
        }
        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
