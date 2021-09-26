package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args)throws IOException {
        Path path = Paths.get("input.txt");
        Files.readAllLines(path);
        List<String> stringList = Files.readAllLines(path).stream().sorted().collect(Collectors.toList());
        Files.write(Paths.get("outSorted.txt"),stringList);
    }
}
