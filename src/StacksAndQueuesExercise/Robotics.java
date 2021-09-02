package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> robots = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());
        String[] robotName = new String[robots.size()];
        int[] processTime = new int[robots.size()];
        for (int i = 0; i < robots.size(); i++) {
            String[] tokes = robots.get(i).split("-");
            String name = tokes[0];
            robotName[i] = name;
            int time = Integer.parseInt(tokes[1]);
            processTime[i] = time;
        }
        String startTime = scanner.nextLine();
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String inputProduct = scanner.nextLine();
        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }
        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
        int[] robotsWork = new int[robots.size()];
        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;
            String products = productsQueue.poll();
            int index = -1;
            for (int i = 0; i < robotsWork.length; i++) {
                if (robotsWork[i] > 0) {
                    robotsWork[i]--;
                }
                if (robotsWork[i] == 0 && index == -1) {
                    index = i;
                }
            }
            if (index != -1) {
                robotsWork[index] = processTime[index];
                System.out.println(printRobotData(robotName[index], products, startTimeInSeconds));
            } else {
                productsQueue.offer(products);
            }
        }
    }

    public static String printRobotData(String name, String products, int beginTime) {
        long hours = (beginTime / (60 * 60)) % 24;
        long minutes = (beginTime / 60) % 60;
        long seconds = beginTime % 60;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return String.format("%s - %s [%s]", name, products, time);
    }
}
