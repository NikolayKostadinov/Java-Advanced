import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) {
        Path inputPath = Paths.get("src/resources/words.txt");
        Path sourcePath = Paths.get("src/resources/text.txt");

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(inputPath);
            String[] words = bufferedReader.readLine().split("\\s+");
            Arrays.stream(words).forEach(word -> wordsCount.putIfAbsent(word, 0));

            bufferedReader.close();
            bufferedReader = Files.newBufferedReader(sourcePath);

            String line = bufferedReader.readLine();
            while (line != null){
                String[] lineWords = line.replaceAll("[,.]", "").split("\\s+");
                for (String lineWord : lineWords) {
                    for (String word : words) {
                        if (lineWord.equals(word)){
                            wordsCount.put(word, wordsCount.get(word) + 1);
                        }
                    }
                }
                line = bufferedReader.readLine();
            }

            for (Map.Entry<String, Integer> word : wordsCount.entrySet()) {
                System.out.println(word.getKey() + " - " + word.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
