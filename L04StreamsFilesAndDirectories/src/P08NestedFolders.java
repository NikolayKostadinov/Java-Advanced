import java.io.*;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/Files-and-Streams");
        String destinationPath = new File("src/resources/08.NestedFolders.txt").getCanonicalPath();

        FileOutputStream fileStream = new FileOutputStream(destinationPath);
        PrintStream print = new PrintStream(fileStream);
        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(file);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            print.println(current.getName());
        }
        print.println(count + " folders");
    }
}
