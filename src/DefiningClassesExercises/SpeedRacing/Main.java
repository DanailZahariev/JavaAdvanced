package DefiningClassesExercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, consumption);
            cars.put(model, car);
        }
        String[] driveCommand = scanner.nextLine().split(" ");
        while (!driveCommand[0].equals("End")) {
            String carModel = driveCommand[1];
            double kilometersToDrive = Double.parseDouble(driveCommand[2]);
            Car car = cars.get(carModel);
            if (!car.drive(kilometersToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }
            driveCommand = scanner.nextLine().split(" ");
        }
        cars.values().forEach(System.out::println);
    }
}
