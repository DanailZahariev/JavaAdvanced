package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            stackNumbers.offer(scanner.nextInt());
        }
        for (int i = 1; i <= s; i++) {
            stackNumbers.poll();
        }
        if (stackNumbers.isEmpty()) {
            System.out.println(0);
        } else if (stackNumbers.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stackNumbers));
        }
    }
}
