package P04MethodsExercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!passLengthValidation(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!passLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!passAtLeast2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (passLengthValidation(password) && passLettersAndDigits(password) && passAtLeast2Digits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean passAtLeast2Digits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    static boolean passLengthValidation(String password) {

        if (password.length() > 5 && password.length() < 11) {
            return true;
        }
        return false;
        //return password.length() > 5 && password.length() < 11;
    }

    static boolean passLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            //char symbol = password.toLowerCase().charAt(i);

            if ((symbol < 48 || symbol > 57) && (symbol < 65 || symbol > 90) && (symbol < 97 || symbol > 122)) {
                return false;
            }
        }
        return true;
    }
}
