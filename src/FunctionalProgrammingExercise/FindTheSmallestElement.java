package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> indexOfMinElement = list -> list.lastIndexOf(Collections.min(list));
//        Consumer<List<Integer>> indexOfMinElement = list -> {
//            int min = Collections.min(list);
//            System.out.println(list.lastIndexOf(min));
//        };
//        indexOfMinElement.accept(numbers);
        System.out.println(indexOfMinElement.apply(numbers));
    }
}
