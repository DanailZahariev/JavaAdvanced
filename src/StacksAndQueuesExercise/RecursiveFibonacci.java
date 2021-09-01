package StacksAndQueuesExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] fibonacci;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        fibonacci = new long[n + 1];
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        return fibonacci[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}