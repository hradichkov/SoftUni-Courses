package P06DefiningClassesExercises.P03CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P02Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, P02Department> departmentMap = new HashMap<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            P02Employee employee = null;

            switch (data.length) {
                case 4:
                    employee = new P02Employee(name, salary, position, department);
                    break;
                case 5:
                    if (data[4].matches("\\d+")) {
                        int age = Integer.parseInt(data[4]);

                        employee = new P02Employee(name, salary, position, department, age);
                    } else {
                        String email = data[4];

                        employee = new P02Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = data[4];
                    int age = Integer.parseInt(data[5]);

                    employee = new P02Employee(name, salary, position, department, email, age);
                    break;
            }
            departmentMap.putIfAbsent(department, new P02Department(department));
            departmentMap.get(department).getEmployees().add(employee);
        }

        P02Department highestPaidDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().averageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());
        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
