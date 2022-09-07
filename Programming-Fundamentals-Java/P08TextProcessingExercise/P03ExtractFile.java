package P08TextProcessingExercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");

        String [] fileNameAndExtension = input[input.length - 1].split("\\.");

        System.out.printf("File name: %s%n", fileNameAndExtension[0]);
        System.out.printf("File extension: %s%n", fileNameAndExtension[1]);
    }
}
