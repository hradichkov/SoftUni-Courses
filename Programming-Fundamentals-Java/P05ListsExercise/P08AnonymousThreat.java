package P05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = data.get(0);

            switch (command) {
                case "merge":
                    int start = Integer.parseInt(data.get(1));
                    int end = Integer.parseInt(data.get(2));

                    if (start < 0) {
                        for (int i = 0; i < end; i++) {
                            stringList.set(0, stringList.get(0) + stringList.get(1));
                            stringList.remove(1);
                        }
                    } else if (end > stringList.size()) {
                        for (int i = start; i < stringList.size(); i++) {
                            stringList.set(start, stringList.get(start) + stringList.get(start + 1));
                            stringList.remove(start + 1);
                        }
                    } else {
                        for (int i = start; i < Math.abs(start - end); i++) {
                            stringList.set(start, stringList.get(start) + stringList.get(start + 1));
                            stringList.remove(start + 1);
                        }
                    }
                    break;

                case "divide":
                    int index = Integer.parseInt(data.get(1));
                    int partitions = Integer.parseInt(data.get(2));


                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(stringList);
    }
}
