package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SImpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "1":
                    text.append(tokens[1]);
                    stack.push(text.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    text.setLength(text.length() - count);
                    stack.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    stack.pop();
                    if (stack.size() > 0) {
                        text = new StringBuilder(stack.peek());
                    } else {
                        text = null;
                    }
                    break;
            }
        }
    }
}
