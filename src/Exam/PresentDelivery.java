package Exam;

import java.util.Scanner;

public class PresentDelivery {
    public static int countOfPresents;
    public static int santaRow;
    public static int santaCol;
    public static int niceKids = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        countOfPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] neighborhood = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            neighborhood[row] = line.toCharArray();
            if (line.contains("S")) {
                santaRow = row;
                santaCol = line.indexOf("S");
            }
            for (char c : line.toCharArray()) {
                if (c == 'V') {
                    countOfPresents--;
                    niceKids--;
                }
            }
        }

        String direction = scanner.nextLine();
        int allNiceKinds = niceKids;
        while (countOfPresents > 0 && !direction.equals("Christmas morning")) {
            if (direction.equals("up")) {
                ensureMoveSanta(neighborhood, santaRow - 1, santaCol);
            } else if (direction.equals("down")) {
                ensureMoveSanta(neighborhood, santaRow + 1, santaCol);
            } else if (direction.equals("left")) {
                ensureMoveSanta(neighborhood, santaRow, santaCol - 1);
            } else {
                ensureMoveSanta(neighborhood, santaRow, santaCol + 1);
            }
            if (countOfPresents <= 0) {
                break;
            }
            direction = scanner.nextLine();
        }
        if (countOfPresents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(neighborhood);
        if (niceKids == 0) {
            System.out.println("Good job, Santa! " + allNiceKinds + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + niceKids + " nice kid/s.");
        }
    }

    private static void ensureMoveSanta(char[][] neighborhood, int newRow, int newCol) {
        char nextStep = neighborhood[newRow][newCol];
        if (nextStep == 'V') {
            countOfPresents--;
        } else if (nextStep == 'C') {
            givePresents(neighborhood, newRow, newCol);
        }
        neighborhood[santaRow][santaCol] = '-';
        neighborhood[newRow][newCol] = 'S';
        santaRow = newRow;
        santaCol = newCol;
    }

    private static void givesPresents(char[][] neighborhood, int r, int c) {
        givePresents(neighborhood, r - 1, c);
        givePresents(neighborhood, r + 1, c);
        givePresents(neighborhood, r, c - 1);
        givePresents(neighborhood, r, c + 1);
    }

    private static void givePresents(char[][] neighborhood, int row, int col) {
        char nextCell = neighborhood[row][col];
        if (nextCell == 'X' || nextCell == 'V') {
            if (nextCell == 'V') {
                niceKids--;
            }
            countOfPresents--;
            neighborhood[row][col] = '-';
        }
    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
