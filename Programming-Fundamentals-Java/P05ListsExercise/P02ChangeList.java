package P05ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = data.get(0);

            switch (command) {
                case "Delete":
                    int deleteElement = Integer.parseInt(data.get(1));

//                    for (int i = 0; i < numList.size(); i++) {
//                        if (numList.get(i) == deleteElement) {
//                            numList.remove(i);
//                        }
//                    }

                    numList.removeAll(List.of(deleteElement));

                    break;
                case "Insert":
                    int insertElement = Integer.parseInt(data.get(1));
                    int position = Integer.parseInt(data.get(2));

                    numList.add(position, insertElement);

                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
