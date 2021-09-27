package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        Path path1 = Path.of(path);
        List<String> lines = Files.readAllLines(path1);
//        lines.stream().map(String::toCharArray).forEach(CharArray -> {
//            int sum = 0;
//            for (char c : CharArray) {
//                sum += c;
//            }
//            System.out.println(sum);
//        });
        for (String line : lines) {
            int sum = 0;
                int currentLine = line.length();
                sum += currentLine;

            System.out.println(sum);
        }
    }
}
