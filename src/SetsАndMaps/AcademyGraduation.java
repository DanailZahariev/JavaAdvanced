package SetsАndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGrades = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());
            studentGrades.putIfAbsent(studentName, grades);
        }
        studentGrades.entrySet().forEach(student -> {
            double avgGrade = 0;
            for (Double grade : student.getValue()) {
                avgGrade += grade/student.getValue().size();
            }
            avgGrade /= student.getValue().size();
            System.out.println(student.getKey() + " is graduated with " + avgGrade);
        });
    }
}
