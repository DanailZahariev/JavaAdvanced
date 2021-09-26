package StreamsFilesAndDirectories;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        String homePath = System.getProperty("user.home");
        FileOutputStream fileOutputStream = new FileOutputStream(homePath + "/" + "outByte.txt");
        PrintStream out = new PrintStream(fileOutputStream);
        int value = fileInputStream.read();
        while (value != -1) {
            if (value != 32 && value != 10) {
                out.print(value);
            } else {
                out.print((char) value);
            }
            value = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
