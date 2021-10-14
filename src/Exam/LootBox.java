package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new)); // попълване на опашка
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt).forEach(secondBox::push); // попълване на стек
        int itemValue = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstItem = firstBox.peek();
            int secondItem = secondBox.pop();
            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                itemValue += sum;
                firstBox.poll();
            } else {
                firstBox.offer(secondItem);
            }

        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (itemValue >= 100) {
            System.out.println("Wow, your prey was epic! Value: " + itemValue);
        } else {
            System.out.println("Poor prey... Value: " + itemValue);
        }
    }
}
