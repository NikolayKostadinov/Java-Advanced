import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        Path sourcePath1 = Paths.get("src/resources/inputOne.txt");
        Path sourcePath2 = Paths.get("src/resources/inputTwo.txt");
        Path destinationPath = Paths.get("src/resources/output.txt");

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(sourcePath1);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(destinationPath);

            String line = bufferedReader.readLine();
            while (line != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedReader = Files.newBufferedReader(sourcePath2);
            line = bufferedReader.readLine();
            while (line != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
