package P03SetsAndMaps;

import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            map.put(name, new ArrayList<>());

            for (double grade : grades) {
                map.get(name).add(grade);
            }
        }
        map.entrySet().forEach(student -> {
            List<Double> grades = student.getValue();
            double totalGrade = 0;

            for (Double grade : grades) {
                totalGrade += grade;
            }
            System.out.println(student.getKey() + " is graduated with " + totalGrade / grades.size());
        });
    }
}
