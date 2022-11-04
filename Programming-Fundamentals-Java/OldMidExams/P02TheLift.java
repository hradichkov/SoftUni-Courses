package OldMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> liftState = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < liftState.size(); i++) {

            if (people == 0) {
                break;
            }

            if (liftState.get(i) < 4) {
                if (people - (4 - liftState.get(i)) >= 0) {
                    people -= 4 - liftState.get(i);
                    liftState.set(i, 4);
                } else {
                    liftState.set(i, people + liftState.get(i));
                    people = 0;
                }

            }
        }

        if (people == 0) {
            if (liftState.get(liftState.size() - 1) < 4) {
                System.out.println("The lift has empty spots!");
            }
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);

        }
        for (int lift : liftState) {
            System.out.print(lift + " ");
        }
    }
}
