package StreamsFilesAndDirectories;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
//        String path = "/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
//        File root = new File(path);
//        Deque<File> dirs = new ArrayDeque<>();
//        dirs.offer(root);
//        int count = 0;
//        while (!dirs.isEmpty()) {
//            File current = dirs.poll();
//            File[] nestedFiles = current.listFiles();
//            for (File nestedFile : nestedFiles)
//                if (nestedFile.isDirectory())
//                    dirs.offer(nestedFile);
//            count++;
//            System.out.println(current.getName());
//        }
//        System.out.println(count + " folders");
//    }
//}
//
        Path path = Paths.get("/Users/danailzahariev/Desktop/Java Advanced/Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");
        File root = path.toFile();
        Deque<File> fileDeque = new ArrayDeque<>();
        fileDeque.offer(root);
        while (!fileDeque.isEmpty()) {
            File file = fileDeque.poll();
            System.out.println(file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        fileDeque.offer(f);
                    } else {
                        System.out.println(f.getName());
                    }
                }
            }
        }
    }
}
//        dfs(root);
//    }
//
//    private static void dfs(File file) {
//        System.out.println(file.getName());
//        File[] files = file.listFiles();
//        if (files != null){
//            for (File f : files) {
//                if (f.isDirectory()){
//                    dfs(f);
//                } else {
//                    System.out.println(f.getName());
//                }
//            }
//        }
//    }
//}
