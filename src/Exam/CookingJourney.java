package Exam;

import java.util.Scanner;

public class CookingJourney {
    static int startRow = 0;
    static int startCol = 0;
    static int totalMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startRow = row;
                startCol = line.indexOf("S");
            }
        }
        boolean isOut = true;
        while (totalMoney < 50 && isOut) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    isOut = move(startRow - 1, startCol, matrix);
                    break;
                case "down":
                    isOut = move(startRow + 1, startCol, matrix);
                    break;
                case "left":
                    isOut = move(startRow, startCol - 1, matrix);
                    break;
                case "right":
                    isOut = move(startRow, startCol + 1, matrix);
                    break;
            }
        }
        String isOutOfBakery = !isOut ? "Bad news! You are out of the pastry shop." :
                "Good news! You succeeded in collecting enough money!";
        System.out.println(isOutOfBakery);
        System.out.println("Money: " + totalMoney);
        printMatrix(matrix);
    }

    public static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';
        if (isOutOfBounds(newRow, newCol, matrix)) {
            return false;
        }
        char symbol = matrix[newRow][newCol];
        if (Character.isDigit(symbol)) {
            totalMoney += symbol - '0';
        } else if (symbol == 'P') {
            matrix[newRow][newCol] = '-';
            int[] secondPillar = findSecondPillar(matrix);
            newRow = secondPillar[0];
            newCol = secondPillar[1];
        }
        matrix[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
        return true;
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] matrix) {
        return newRow >= matrix.length || newRow < 0 || newCol >= matrix[newRow].length ||
                newCol < 0;
    }

    public static int[] findSecondPillar(char[][] matrix) {
        int[] index = null;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    index = new int[]{row, col};
                    break;
                }
            }
            if (index != null) {
                break;
            }
        }
        return index;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
