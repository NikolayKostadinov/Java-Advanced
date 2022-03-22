import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class P03AllCapitals {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/resources/input.txt");
        Path destinationPath = Paths.get("src/resources/output.txt");

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(sourcePath);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(destinationPath);

            String line = bufferedReader.readLine();
            while (line != null){
                bufferedWriter.write(line.toUpperCase(Locale.ROOT));
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
