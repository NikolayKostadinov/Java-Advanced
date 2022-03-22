import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        File file = new File("src/resources/Exercises Resources");

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(file);
        long folderSize = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                } else {
                    folderSize += nestedFile.length();
                }
        }
        System.out.printf("Folder size: %d", folderSize);
    }
}
