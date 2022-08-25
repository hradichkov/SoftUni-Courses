package P03ArraysExercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String second : secondArr) {
            for (String first : firstArr) {
                if (second.equals(first)) {
                    System.out.print(second + " ");
                }
            }
        }
//        for (int i = 0; i < secondArr.length; i++) {
//            for (int j = 0; j < firstArr.length; j++) {
//                if (secondArr[i].equals(firstArr[j])) {
//                    System.out.print(secondArr[i] + " ");
//                }
//            }
//        }
    }
}
