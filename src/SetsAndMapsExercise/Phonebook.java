package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String contactName = tokens[0];
            String phoneNumber = tokens[1];
            if (phonebook.containsKey(contactName)) {
                phonebook.put(contactName, phoneNumber);
            } else {
                phonebook.put(contactName, phoneNumber);
            }
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }
    }
}
