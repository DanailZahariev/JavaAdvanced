package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt");
        Map<String, Integer> wordsCount = new LinkedHashMap<>();
        List<String> allLines = Files.readAllLines(path);
        allLines.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(word -> wordsCount.put(word, 0)));
        Path pathText = Path.of("/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt");
        List<String> textAllLines = Files.readAllLines(pathText);
        for (String textAllLine : textAllLines) {
            String[] line = textAllLine.split("\\s+");
            Arrays.stream(line).forEach(word -> {
                if (wordsCount.containsKey(word)) {
                    int count = wordsCount.get(word);
                    wordsCount.put(word, count + 1);
                }
            });
        }
        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        PrintWriter writer = new PrintWriter("result.txt");
        wordsCount.forEach((key, value) -> writer.println(key + " - " + value));
        writer.close();
    }
}
