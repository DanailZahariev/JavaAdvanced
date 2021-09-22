package SetsАndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> doublesWithOccurrences = new LinkedHashMap<>();
        for (double value : values) {
            if (!doublesWithOccurrences.containsKey(value)) {
                doublesWithOccurrences.put(value, 1);
            } else {
                doublesWithOccurrences.put(value, doublesWithOccurrences.get(value) + 1);
            }
        }
        for (Double aDouble : doublesWithOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", aDouble, doublesWithOccurrences.get(aDouble));
        }
    }
}
