package P05Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numList.size() - 1; i++) {
            if (numList.get(i).equals(numList.get(i + 1))) {
                numList.set(i, numList.get(i) + numList.get(i + 1));
                numList.remove(i + 1);

                i = -1;
            }
        }
        System.out.println(joinElementsByDelimeter(numList, " "));
    }

    private static String joinElementsByDelimeter(List<Double> numList, String delimiter) {
        String output = "";
        for (Double num : numList) {

            DecimalFormat df = new DecimalFormat("0.#"); // не принтира ако е нула на мястото на #
            String numDf = df.format(num) + delimiter; // форматира числото по патерна и конкатенира с делимитера
            output += numDf; // добавя в общ стринг
        }
        return output;
    }
}
