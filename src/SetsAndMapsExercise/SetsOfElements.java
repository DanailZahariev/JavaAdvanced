package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        int countFirstSet = scanner.nextInt();
        int countSecondSet = scanner.nextInt();
        for (int i = 0; i < countFirstSet; i++) {
            int number = scanner.nextInt();
            firstSet.add(number);
        }
        for (int i = 0; i < countSecondSet; i++) {
            int number = scanner.nextInt();
            secondSet.add(number);
        }
        firstSet.stream().filter(secondSet::contains).map(num -> num + " ").forEach(System.out::print);
//        firstSet.retainAll(secondSet);
//        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
