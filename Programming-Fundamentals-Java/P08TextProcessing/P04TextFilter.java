package P08TextProcessing;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : bannedWords) {
            String replacementWord = getReplacementWord(banWord);

            if (text.contains(banWord)) {
                text = text.replace(banWord, replacementWord);
            }

        }
        System.out.println(text);
    }

    private static String getReplacementWord(String banWord) {
        //String[] replacementWord = new String[banWord.length()];

        StringBuilder replacementWord = new StringBuilder();

        for (int i = 0; i < banWord.length(); i++) {
            //replacementWord[i] = "*";
            replacementWord.append("*");
        }
        return replacementWord.toString();
    }
}
