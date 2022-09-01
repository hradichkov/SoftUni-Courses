package P06ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Random randomGenerator = new Random();

        for (int i = 0; i < input.length; i++) {
            int randomIndexA = randomGenerator.nextInt(input.length);
            int randomIndexB = randomGenerator.nextInt(input.length);

            String oldWord = input[randomIndexA];
            input[randomIndexA] = input[randomIndexB];
            input[randomIndexB] = oldWord;
        }

//        for (String word : input) {
//            System.out.println(word);
//        }

        System.out.println(String.join(System.lineSeparator(), input));
    }
}
