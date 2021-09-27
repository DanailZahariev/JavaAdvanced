package StreamsFilesAndDirectoriesExercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File folder = new File(path);
        File[] files = folder.listFiles();
        int sum = 0;
        for (File file : files) {
            sum += file.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
