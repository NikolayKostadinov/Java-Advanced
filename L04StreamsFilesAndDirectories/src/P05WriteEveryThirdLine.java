import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String sourcePath = new File("src/resources/input.txt").getCanonicalPath();
        String destinationPath = new File("src/resources/05.WriteEveryThirdLineOutput.txt").getCanonicalPath();

        FileInputStream inputFileStream = new FileInputStream(sourcePath);
        FileOutputStream outputFileStream = new FileOutputStream(destinationPath);

        Scanner scan = new Scanner(inputFileStream);
        PrintStream printer = new PrintStream(outputFileStream);
        int lineNumber = 1;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (lineNumber % 3 == 0) {
                printer.println(line);
            }
            lineNumber++;
        }

        inputFileStream.close();
        outputFileStream.close();
    }
}
