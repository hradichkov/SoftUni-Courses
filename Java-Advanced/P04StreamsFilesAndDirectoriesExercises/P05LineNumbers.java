package P04StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            String line = bufferedReader.readLine();
            int count = 0;

            while (line != null) {
                count++;
                printWriter.println(count + ". " + line);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
