package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> personWithEmail = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                personWithEmail.put(name, email);
            }
            name = scanner.nextLine();
        }
        personWithEmail.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
