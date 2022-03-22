import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P01SumLines {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/resources/input.txt");
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(sourcePath);
            String line = bufferedReader.readLine();
            while (line != null){
                System.out.println(line.chars().sum());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
