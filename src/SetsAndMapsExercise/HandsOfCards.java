package SetsAndMapsExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String cardStr = input.split(": ")[1];
            String[] cardsArray = cardStr.split(", ");
            Set<String> cards = new HashSet<>();
            Collections.addAll(cards, cardsArray);
            if (playerCards.containsKey(name)) {
                Set<String> currentCard = playerCards.get(name);
                currentCard.addAll(cards);
                playerCards.put(name, currentCard);
            } else {
                playerCards.put(name, cards);
            }
            input = scanner.nextLine();
        }
        playerCards.entrySet().forEach(key -> {
            String name = key.getKey();
            Set<String> cards = key.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> pointsMap = getCardValue();
        int totalSum = 0;
        for (String card : cards) {
            int points = 0;
            if (card.contains("10")) {
                char type = card.charAt(2);
                points = 10 * pointsMap.get(type);
            } else {
                char cardNum = card.charAt(0);
                char cardType = card.charAt(1);
                points = pointsMap.get(cardNum) * pointsMap.get(cardType);
            }
            totalSum += points;
        }
        return totalSum;
    }

    private static Map<Character, Integer> getCardValue() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
    }
}
