package P04StreamsFilesAndDirectories;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced" +
                "\\4 седмица - Streams, Files and Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        int count = 0;

        while (line != null) {
            count++;
            if (count % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
        }
        writer.close();
    }
}
