package P04StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) {

//        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
//                "4 седмица - Streams, Files and Directories\\" +
//                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
//             BufferedReader bufferedReader2 = new BufferedReader(new FileReader("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
//                     "4 седмица - Streams, Files and Directories\\" +
//                     "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
//             PrintWriter printWriter = new PrintWriter(new FileWriter("output2.txt", true))) {
//
//            bufferedReader1.lines().forEach(printWriter::println);
//            bufferedReader2.lines().forEach(line -> printWriter.println(line));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Path input1 = Paths.get("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path input2 = Paths.get("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path output = Paths.get("output.txt");

        try {
            List<String> firstFile = Files.readAllLines(input1);
            List<String> secondFile = Files.readAllLines(input2);

            Files.write(output,firstFile, StandardOpenOption.APPEND);
            Files.write(output,secondFile, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
