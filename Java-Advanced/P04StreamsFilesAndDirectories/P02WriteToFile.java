package P04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced" +
                "\\4 седмица - Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            int read = fileInputStream.read();

            Set<Character> punctuations = Set.of(',', '.', '!', '?');

            while (read != -1) {
                if (!punctuations.contains((char) read)) {
                    fileOutputStream.write(read);
                }
                read = fileInputStream.read();
            }
        } catch (IOException ignored) {
        }
    }
}
