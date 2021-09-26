package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "src/input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        int value = inputStream.read();
        while (value != -1) {
            System.out.print(Integer.toBinaryString(value) + " ");
            value = inputStream.read();
        }
        inputStream.close();
    }
}
