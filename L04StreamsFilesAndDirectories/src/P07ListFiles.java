import java.io.*;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {
        File path = new File("src/resources/Files-and-Streams");

        String destinationPath = new File("src/resources/07.ListFiles.txt").getCanonicalPath();

        FileWriter fileWriter = new FileWriter(destinationPath);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        File[] folder = path.listFiles();

        for (File file : folder) {
            if (!file.isDirectory()){
                fileWriter.write(String.format("%s: [%d]%n",file.getName(), file.length()));
            }
        }

        writer.flush();
        writer.close();
    }
}
