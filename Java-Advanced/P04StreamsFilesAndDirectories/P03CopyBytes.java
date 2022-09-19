package P04StreamsFilesAndDirectories;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced" +
                "\\4 седмица - Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            PrintWriter writer = new PrintWriter(fileOutputStream);
            int read = fileInputStream.read();

            while (read != -1) {
                if (read == ' ') {
                    writer.print(' ');
                } else if (read == 10) {
                    writer.println();
                } else {
                    writer.print(read);
                }
                read = fileInputStream.read();
            }

            writer.close();

        } catch (IOException ignored) {

        }

    }
}
