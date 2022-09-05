package P07AssociativeArraysExercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
            }
            studentsMap.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            double totalGrade = 0;
            List<Double> grades = entry.getValue();

            for (Double grade : grades) {
                totalGrade += grade;
            }

            double averageGrade = totalGrade / grades.size();

            if (averageGrade >= 4.5) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }
    }
}
