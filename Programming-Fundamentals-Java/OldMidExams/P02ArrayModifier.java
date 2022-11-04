package OldMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(" ")).toList();
            String command = data.get(0);

            switch (command) {
                case "swap" -> {
                    int swapIndex1 = Integer.parseInt(data.get(1));
                    int swapIndex2 = Integer.parseInt(data.get(2));
                    int term = numList.get(swapIndex1);
                    numList.set(swapIndex1, numList.get(swapIndex2));
                    numList.set(swapIndex2, term);
                }
                case "multiply" -> {
                    int multiplyIndex1 = Integer.parseInt(data.get(1));
                    int multiplyIndex2 = Integer.parseInt(data.get(2));
                    numList.set(multiplyIndex1, numList.get(multiplyIndex1) * numList.get(multiplyIndex2));
                }
                case "decrease" -> numList.replaceAll(integer -> integer - 1);
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < numList.size() - 1; i++) {
            System.out.print(numList.get(i) + ", ");
        }
        System.out.print(numList.get(numList.size() - 1));
    }
}
