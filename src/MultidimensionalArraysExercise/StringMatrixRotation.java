    package MultidimensionalArraysExercise;

    import java.util.ArrayList;
    import java.util.Scanner;

    public class StringMatrixRotation {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String rotation = scanner.nextLine();
            int angle = Integer.parseInt(rotation.split("[()]+")[1]) % 360;
            String input = scanner.nextLine();
            ArrayList<String> matrixLine = new ArrayList<>();
            int maxLength = input.length();
            while (!input.equals("END")) {
                matrixLine.add(input);
                input = scanner.nextLine();
                if (input.length() > maxLength) {
                    maxLength = input.length();


                }
            }
            int rows = matrixLine.size();
            int cols = maxLength;
            char[][] matrix = new char[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (col < matrixLine.get(row).length()) {
                        matrix[row][col] = matrixLine.get(row).charAt(col);
                    } else {
                        matrix[row][col] = ' ';
                    }
                }
            }
            if (angle == 90) {
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
            } else if (angle == 180) {
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
            } else if (angle == 270) {
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
            } else {
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
            }
        }
    }
