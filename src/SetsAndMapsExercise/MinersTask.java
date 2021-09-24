package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> totalResource = new LinkedHashMap<>();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (totalResource.containsKey(resource)) {
                int currentQuantity = totalResource.get(resource);
                totalResource.put(resource, quantity + currentQuantity);
            } else {
                totalResource.put(resource, quantity);
            }
            resource = scanner.nextLine();
        }
        totalResource.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
