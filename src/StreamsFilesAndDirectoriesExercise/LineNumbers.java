package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        List<String> stringList = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("outputNumLines.txt");
        int countLines = 1;
        for (String line : stringList) {
            writer.println(countLines + ". " + line);
            countLines++;
        }
        writer.close();
    }
}
