package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            if (command.equals("2")) {
                numbers.pop();
            } else if (command.equals("3")) {
                System.out.println(Collections.max(numbers));
            } else if (command.split(" ")[0].equals("1")) {
                int numElement = Integer.parseInt(command.split(" ")[1]);
                numbers.push(numElement);
            }
        }
    }
}
