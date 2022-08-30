package P05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; firstPlayer.size() > 0 && secondPlayer.size() > 0; i++) {

            if (firstPlayer.get(i) > secondPlayer.get(i)) {
                firstPlayer.add(firstPlayer.get(i));
                firstPlayer.add(secondPlayer.get(i));

            } else if (secondPlayer.get(i) > firstPlayer.get(i)) {
                secondPlayer.add(secondPlayer.get(i));
                secondPlayer.add(firstPlayer.get(i));

            }
            firstPlayer.remove(i);
            secondPlayer.remove(i);
            i = -1;
        }

        if (firstPlayer.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayer));
        } else {
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayer));
        }
    }

    public static int getCardsSum(List<Integer> listCards) {
        int sum = 0;
        for (int card : listCards) {
            sum += card;
        }
        return sum;
    }
}
