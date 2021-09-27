package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        byte[] bytes = Files.readAllBytes(Path.of(path));
        int sum = 0;
        for (byte aByte : bytes) {
            if (aByte != 10 && aByte != 13) {
                sum += aByte;
            }
        }
        System.out.println(sum);
    }
}
