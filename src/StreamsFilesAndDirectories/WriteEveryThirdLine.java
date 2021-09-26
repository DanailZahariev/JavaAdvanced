package StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);


    }
}
