package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRobots = scanner.nextLine();
        String[] robotsData = inputRobots.split(";");
        LinkedHashMap<String, Integer> robots = getRobotsData(robotsData);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTime(robotsData);
        String startTime = scanner.nextLine();
        int startTimeInSeconds = startTimeInSeconds(startTime);
        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }
        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            boolean taken = false;
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    taken = true;
                    break;
                }
            }
            if (!taken) {
                products.offer(currentProduct);
            }
        }
    }


    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTime(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String name = robotData.split("-")[0];
            robots.put(name, 0);
        }
        return robots;
    }

    private static int startTimeInSeconds(String startTime) {
        int hour = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        int startTimeSeconds = hour * 3600 + minutes * 60 + seconds;
        return startTimeSeconds;
    }

    private static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static LinkedHashMap<String, Integer> getRobotsData(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String name = robotData.split("-")[0];
            int time = Integer.parseInt(robotData.split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
