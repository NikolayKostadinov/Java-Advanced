import java.io.*;
import java.util.Scanner;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {
        String sourcePath = new File("src/resources/input.txt").getCanonicalPath();
        String destinationPath = new File("src/resources/03.CopyBytesOutput.txt").getCanonicalPath();


        FileInputStream inputFileStream = new FileInputStream(sourcePath);
        FileOutputStream outputFileStream = new FileOutputStream(destinationPath);

        Scanner scan = new Scanner(inputFileStream);
        PrintStream printer = new PrintStream(outputFileStream);

        int newByte = inputFileStream.read();
        while (newByte != -1) {
            if (' ' == (char) newByte || '\n' == (char) newByte) {
                printer.print((char) newByte);
            } else {
                printer.print(newByte);
            }
            newByte = inputFileStream.read();
        }

        inputFileStream.close();
        outputFileStream.close();
    }
}
