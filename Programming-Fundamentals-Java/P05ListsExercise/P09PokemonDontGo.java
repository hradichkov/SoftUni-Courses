package P05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;

        while (numList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;

            if (index >= 0 && index < numList.size()) {
                removedElement = numList.get(index);

                numList.remove(index);

            } else if (index < 0) {
                removedElement = numList.get(0);

                //numList.remove(0);
                numList.set(0, numList.get(numList.size() - 1));

            } else {
                removedElement = numList.get(numList.size() - 1);

                numList.remove(numList.size() - 1);
                numList.add(numList.get(0));

            }
            changedElements(numList, removedElement);
            sum += removedElement;
        }
        System.out.println(sum);
    }

    private static void changedElements(List<Integer> numList, int removedElement) {
        for (int j = 0; j < numList.size(); j++) {
            if (numList.get(j) <= removedElement) {
                numList.set(j, numList.get(j) + removedElement);
            } else {
                numList.set(j, numList.get(j) - removedElement);
            }
        }
    }
}
