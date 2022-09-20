package P04StreamsFilesAndDirectoriesExercises;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
             Scanner textScanner = new Scanner(new FileReader("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                     "4 седмица - Streams, Files and Directories\\" +
                     "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
             PrintWriter printWriter = new PrintWriter("output.txt")) {

            LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();
            Arrays.stream(scanner.nextLine().split(" ")).forEach(word -> wordsMap.put(word, 0));

            while (textScanner.hasNext()) {
                String textInput = textScanner.next();

                if (wordsMap.containsKey(textInput)) {
                    int occurrences = wordsMap.get(textInput);
                    occurrences++;
                    wordsMap.put(textInput, occurrences);
                }
            }

            wordsMap.entrySet().forEach(word -> printWriter.println(word.getKey() + " - " + word.getValue()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
