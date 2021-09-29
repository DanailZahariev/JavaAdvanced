package FunctionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderByAge {
    public static class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Supplier<Person> personCreator = () -> {
            String[] tokens = scanner.nextLine().split(", ");
            return new Person(tokens[0], Integer.parseInt(tokens[1]));
        };
        List<Person> people = IntStream.range(0, n).mapToObj(ignored -> personCreator.get()).collect(Collectors.toList());
        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split("\\s+");
        Predicate<Person> filter = getFilter(condition, ageLimit);
        var printer = printPerson(format);
        people.stream().filter(filter).forEach(printer);
    }

    public static Predicate<Person> getFilter(String condition, int age) {
        return condition.equals("older") ? person -> person.age >= age : person -> person.age <= age;
    }

    public static Consumer<Person> printPerson(String[] format) {
        if (format.length == 2) {
            return person -> System.out.println(person.name + " - " + person.age);
        } else if (format[0].equals("name")) {
            return person -> System.out.println(person.name);
        }
        return person -> System.out.println(person.age);
    }
}
