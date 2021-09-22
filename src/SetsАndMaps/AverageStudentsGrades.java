package SetsАndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> studentGrades = new TreeMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            studentGrades.putIfAbsent(studentName, new ArrayList<>());
            studentGrades.get(studentName).add(grade);
        }
        for (String name : studentGrades.keySet()) {
            System.out.print(name + " -> ");
            studentGrades.get(name).forEach(student -> {
                System.out.printf("%.2f ", student);
            });
            double avgGrade = 0;
            for (Double grade : studentGrades.get(name)) {
                avgGrade += grade;
            }
            avgGrade /= studentGrades.get(name).size();
            System.out.printf("(avg: %.2f)%n", avgGrade);
        }
    }
}
