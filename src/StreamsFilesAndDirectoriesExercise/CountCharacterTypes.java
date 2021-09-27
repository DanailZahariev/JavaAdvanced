package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        List<String> stringList = Files.readAllLines(Path.of(path));
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuations = 0;
        for (String line : stringList) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') {
                    countVowels++;
                } else if (currentSymbol == '!' || currentSymbol == '?' || currentSymbol == ',' || currentSymbol == '.') {
                    countPunctuations++;
                } else {
                    countConsonants++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputSymbols.txt"));
        writer.write("Vowels: " + countVowels + "\\n");
        writer.write("Consonants: " + countConsonants + "\\n");
        writer.write("Punctuation: " + countPunctuations + "\\n");
        writer.close();
    }
}
