package P04StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileReader fileReader = new FileReader(path);
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {
            int oneSymbol = fileReader.read();

            while (oneSymbol != -1) {
                char currentSymbol = (char) oneSymbol;
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'o' || currentSymbol == 'u' || currentSymbol == 'i') {
                    vowels++;
                } else if (currentSymbol == '!' || currentSymbol == ',' || currentSymbol == '.' || currentSymbol == '?') {
                    punctuation++;
                } else if (!Character.isWhitespace(currentSymbol)) {
                    consonants++;
                }
                oneSymbol = fileReader.read();
            }
            printWriter.println("Vowels: " + vowels);
            printWriter.println("Consonants: " + consonants);
            printWriter.println("Punctuation: " + punctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
