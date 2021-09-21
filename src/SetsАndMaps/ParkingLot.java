package SetsАndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String registration = tokens[1];
            if (command.equals("IN")){
                parkingLot.add(registration);
            } else {
                parkingLot.remove(registration);
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}