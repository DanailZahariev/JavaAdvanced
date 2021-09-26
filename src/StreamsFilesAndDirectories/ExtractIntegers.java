package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        String homePath = System.getProperty("user.home");
        FileOutputStream fileOutputStream = new FileOutputStream(homePath + "/" + "outInt.txt");
        PrintStream out = new PrintStream(fileOutputStream);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                out.println(number);
            } else {
                scanner.next();
            }
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
