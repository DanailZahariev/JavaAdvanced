package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        String homePath = System.getProperty("user.home");
        FileOutputStream fileOutputStream = new FileOutputStream(homePath + "/" + "out.txt");
        int value = fileInputStream.read();
        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        while (value != -1) {
            char current = (char) value;
            if (!punctuation.contains(current)) {
                fileOutputStream.write(current);
            }
            value = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
