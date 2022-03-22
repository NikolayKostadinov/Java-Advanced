import java.io.*;
import java.util.Scanner;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        String sourcePath = new File("src/resources/input.txt").getCanonicalPath();
        String destinationPath = new File("src/resources/02.WriteToFileOutput.txt").getCanonicalPath();

        FileInputStream inputFileStream = new FileInputStream(sourcePath);
        FileOutputStream outputFileStream = new FileOutputStream(destinationPath);

        Scanner scan = new Scanner(inputFileStream);
        PrintStream printer = new PrintStream(outputFileStream);
        while (scan.hasNextLine()){
            printer.println(scan.nextLine().replaceAll("[,\\.!?]", ""));
        }

        inputFileStream.close();
        outputFileStream.close();
    }
}
