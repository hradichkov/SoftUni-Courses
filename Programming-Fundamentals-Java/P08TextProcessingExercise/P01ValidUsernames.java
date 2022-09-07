package P08TextProcessingExercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            boolean isValid = false;
            if (username.length() > 2 && username.length() < 17) {
                for (int i = 0; i < username.length(); i++) {
                    char symbol = username.charAt(i);

                    if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }
            }
            if (isValid) {
                System.out.println(username);
            }
        }
    }
}
