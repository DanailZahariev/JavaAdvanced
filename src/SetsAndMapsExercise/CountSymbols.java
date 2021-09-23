package SetsAndMapsExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> countSymbol = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (countSymbol.containsKey(currentSymbol)) {
                int currentCount = countSymbol.get(currentSymbol);
                countSymbol.put(currentSymbol, currentCount + 1);
            } else {
                countSymbol.put(currentSymbol, 1);
            }
        }
        countSymbol.forEach((key1, value) -> System.out.println(key1 + ": " + value + " time/s"));
    }
}
