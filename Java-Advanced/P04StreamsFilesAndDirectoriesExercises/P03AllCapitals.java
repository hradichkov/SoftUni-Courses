package P04StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"));

            bufferedReader.lines().forEach(line -> printWriter.println(line.toUpperCase()));

            //String line = bufferedReader.readLine();

//            while (line != null){
//                line = line.toUpperCase();
//                printWriter.println(line);
//
//                line = bufferedReader.readLine();
//            }

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
