package OldMidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double sum = 0;

        for (Integer num : numList) {
            sum += num;
        }

        double averageSum = sum / numList.size();

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) <= averageSum) {
                numList.remove(i);
                i--;
            }
        }
        Collections.sort(numList);
        Collections.reverse(numList);

        if (numList.size() == 0) {
            System.out.println("No");
        } else if (numList.size() <= 5) {
            System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.print(numList.get(i) + " ");
            }
        }
    }
}
