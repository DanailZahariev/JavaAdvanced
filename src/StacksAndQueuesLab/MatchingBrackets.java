package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String fileExpression = scanner.nextLine();
        for (int i = 0; i < fileExpression.length(); i++) {
            char currentChar = fileExpression.charAt(i);
            if (currentChar == '(') {
                stack.push(i);
            } else if (currentChar == ')') {
                int startIndex = stack.pop();
                String contents = fileExpression.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
