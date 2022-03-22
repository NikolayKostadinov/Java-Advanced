import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/resources/input.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(sourcePath)) {
            long sumBytes = 0;
            String line = bufferedReader.readLine();
            while (line != null){
                sumBytes += line.chars().sum();
                line = bufferedReader.readLine();
            }

            System.out.println(sumBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
