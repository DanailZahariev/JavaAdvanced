package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Function<String, Integer> countInt = str -> str.split(", ").length;
        Function<String, Integer> sumInt = str -> Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt)
                .sum();
        System.out.println("Count = " + countInt.apply(input));
        System.out.println("Sum = " + sumInt.apply(input));
    }
}
