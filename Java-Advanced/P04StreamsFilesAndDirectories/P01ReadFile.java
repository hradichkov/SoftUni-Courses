package P04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced" +
                "\\4 седмица - Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            int read = fileInputStream.read();

            while (read != -1) {
                System.out.print(Integer.toBinaryString(read) + " ");
                read = fileInputStream.read();
            }
        } catch (IOException ignored) {
        }
    }
}
