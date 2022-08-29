package P05Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = data.get(0);

            switch (command) {
                case "Add":
                    int addNum = Integer.parseInt(data.get(1));
                    numList.add(addNum);
                    break;

                case "Remove":
                    int removeNum = Integer.parseInt(data.get(1));
                    numList.remove(Integer.valueOf(removeNum));
                    break;

                case "RemoveAt":
                    int indexNumRemove = Integer.parseInt(data.get(1));
                    numList.remove(indexNumRemove);
                    break;

                case "Insert":
                    int insertNum = Integer.parseInt(data.get(1));
                    int indexNum = Integer.parseInt(data.get(2));

                    numList.add(indexNum, insertNum);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int num : numList) {
            System.out.print(num + " ");
        }
    }
}
