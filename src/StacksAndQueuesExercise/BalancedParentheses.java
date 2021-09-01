package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean balanced = false;
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openBrackets.push(currentSymbol);
            } else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {
                if (openBrackets.isEmpty()) {
                    balanced = false;
                    break;
                }
                char lastOpen = openBrackets.pop();
                if (lastOpen == '(' && currentSymbol == ')') {
                    balanced = true;
                } else if (lastOpen == '{' && currentSymbol == '}') {
                    balanced = true;
                } else if (lastOpen == '[' && currentSymbol == ']') {
                    balanced = true;
                } else {
                    balanced = false;
                    break;
                }
            }
        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
    }
}
