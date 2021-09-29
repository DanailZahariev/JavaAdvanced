package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        String collect = evenNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect);
        String collect1 = evenNumbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect1);
    }
}
