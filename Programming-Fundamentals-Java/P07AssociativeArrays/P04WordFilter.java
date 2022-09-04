package P07AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0)
                .toArray(String[]::new);

//        for (String word : wordsArr) {
//            if (word.length() % 2 == 0) {
//                System.out.println(word);
//            }
//        }
        System.out.println(String.join(System.lineSeparator(), wordsArr)); // разделителя е нов ред
    }
}
