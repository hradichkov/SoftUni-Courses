package P05ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> specialNumAndPower = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i).equals(specialNumAndPower.get(0))) {
                for (int j = 0; j < specialNumAndPower.get(1); j++) {
                    if (i - 1 >= 0) {
                        numList.remove(i - 1);
                        i--;
                    }
                    if (i + 1 < numList.size()) {
                        numList.remove(i + 1);
                    }
                }
            }
        }
        numList.removeAll(Collections.singleton(specialNumAndPower.get(0)));
        int sum = 0;
        for (Integer num : numList) {
            sum += num;
        }
        System.out.println(sum);
    }
}
