import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P04CountCharacterTypes {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("src/resources/input.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(sourcePath)) {
            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;

            String line = bufferedReader.readLine();
            while (line != null) {
                for (char chr : line.toCharArray()) {
                    if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o'|| chr == 'u') {
                        vowels++;
                    } else if(chr == '.' || chr == '!' || chr == ',' || chr == '?'){
                        punctuation++;
                    } else if(chr !=' '){
                        consonants++;
                    }
                }
                line = bufferedReader.readLine();
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
            System.out.println("Punctuation: " + punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
