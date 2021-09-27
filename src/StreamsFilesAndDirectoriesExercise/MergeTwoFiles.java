package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path pathOne = Path.of("/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path pathTwo = Path.of("/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        List<String> allLinesOne = Files.readAllLines(pathOne);
        List<String> allLinesTwo = Files.readAllLines(pathTwo);
        PrintWriter writer = new PrintWriter("outputMerge.txt");
        allLinesOne.forEach(writer::println);
        allLinesTwo.forEach(writer::println);
        writer.close();
    }
}
