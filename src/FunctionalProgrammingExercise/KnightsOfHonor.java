package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> personsSir = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<List<String>> print = names -> names.forEach(name -> System.out.println("Sir " + name));
        print.accept(personsSir);
    }
}
