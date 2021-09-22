package SetsАndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Double>> allShops = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            allShops.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> productsAndPrices = allShops.get(shop);
            productsAndPrices.put(product, price);
            input = scanner.nextLine();
        }
        for (String shop : allShops.keySet()) {
            System.out.println(shop + "->");
            for (var s : allShops.get(shop).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", s.getKey(), s.getValue());
            }
        }
    }
}
