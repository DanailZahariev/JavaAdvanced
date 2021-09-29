package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.equals("add")) {
                Function<int[], int[]> increment = num -> Arrays.stream(num).map(e -> e += 1).toArray();
                numbers = increment.apply(numbers);
            } else if (command.equals("multiply")) {
                Function<int[], int[]> multiply = num -> Arrays.stream(num).map(e -> e *= 2).toArray();
                numbers = multiply.apply(numbers);
            } else if (command.equals("subtract")) {
                Function<int[], int[]> subtract = num -> Arrays.stream(num).map(e -> e -= 1).toArray();
                numbers = subtract.apply(numbers);
            } else if (command.equals("print")) {
                Consumer<int[]> print = num -> Arrays.stream(num).forEach(e -> System.out.print(e + " "));
                print.accept(numbers);
                System.out.println();
            }
            command = scanner.nextLine();
        }
    }
}
