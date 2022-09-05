package P07AssociativeArraysExercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> studentMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" : ");
            String course = data[0];
            String student = data[1];

            if (!studentMap.containsKey(course)) {
                studentMap.put(course, new ArrayList<>());
            }
            studentMap.get(course).add(student);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : studentMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());

            for (String student : entry.getValue()) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
