package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputCapitals.txt"));
        Files.readAllLines(Path.of(path)).forEach(line -> {
            try {
                writer.write(line.toUpperCase());
                writer.newLine();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        writer.close();
    }
}
