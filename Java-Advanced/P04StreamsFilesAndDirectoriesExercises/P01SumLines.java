package P04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) {

        String path = "C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                long sum = 0;
                char[] charactersFromLine = line.toCharArray();

                for (char c : charactersFromLine) {
                    sum += c;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        FileReader fileReader = new FileReader(path);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        String line = bufferedReader.readLine();
//
//        while (line != null) {
//            long sum = 0;
//            for (int i = 0; i < line.length(); i++) {
//                char symbol = line.charAt(i);
//                sum += symbol;
//            }
//
//            System.out.println(sum);
//            line = bufferedReader.readLine();
//        }
//        bufferedReader.close();
    }
}
