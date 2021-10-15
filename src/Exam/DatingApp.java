package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt).forEach(males::push);
        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(females::offer);
        int matches = 0;
        while (!females.isEmpty() && !males.isEmpty()) {
            int femalePeek = females.peek();
            int malePeek = males.peek();
            if (femalePeek <= 0) {
                females.poll();
                continue;
            }
            if (malePeek <= 0) {
                males.pop();
                continue;
            }
            if (femalePeek % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }
            if (malePeek % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (femalePeek == malePeek) {
                matches++;
                females.poll();
                males.pop();
            } else {
                females.poll();
                males.push(males.pop() - 2);
            }
        }
        System.out.println("Matches: " + matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
