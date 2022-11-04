package OldMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (index < 0 || index >= numList.size()) {
                input = scanner.nextLine();
                continue;
            }

            if (numList.get(index) != -1) {
                int reduceOrIncreaseNum = numList.get(index);
                numList.set(index, -1);
                count++;

                for (int i = 0; i < numList.size(); i++) {
                    if (numList.get(i) > reduceOrIncreaseNum && numList.get(i) != -1) {
                        numList.set(i, numList.get(i) - reduceOrIncreaseNum);
                    } else if (numList.get(i) <= reduceOrIncreaseNum && numList.get(i) != -1) {
                        numList.set(i, numList.get(i) + reduceOrIncreaseNum);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> %s", count, numList.toString().replaceAll("[\\[\\],]", ""));
        //System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
