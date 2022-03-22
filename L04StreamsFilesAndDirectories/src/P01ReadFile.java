import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = new File("src/resources/input.txt").getCanonicalPath();

        FileInputStream fileStream = new FileInputStream(path);

        int newByte = fileStream.read();
        while (newByte != -1) {
            System.out.print(Integer.toBinaryString(newByte) + " ");
            newByte = fileStream.read();
        }
        fileStream.close();
    }
}
