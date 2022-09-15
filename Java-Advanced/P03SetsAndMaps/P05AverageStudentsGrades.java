package P03SetsAndMaps;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            Double grade = Double.parseDouble(data[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double totalGrade = 0;
            List<Double> grades = entry.getValue();

            for (Double grade : grades) {
                totalGrade += grade;
            }
            double averageGrade = totalGrade / grades.size();

            System.out.printf("%s -> ", entry.getKey());

            for (Double grade : grades) {
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)%n", averageGrade);
        }

    }
}
