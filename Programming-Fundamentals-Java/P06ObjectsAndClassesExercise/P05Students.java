package P06ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P05Students {

    static class Students {
        private String firstName;
        private String lastName;
        private double grade;

        public Students(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public Double getGrade() {
            return this.grade;
        }

//        public String getFirstName() {
//            return this.firstName;
//        }
//
//        public String getLastName() {
//            return this.lastName;
//        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            String firstName = data.split(" ")[0];
            String lastName = data.split(" ")[1];
            double grade = Double.parseDouble(data.split(" ")[2]);

            Students student = new Students(firstName, lastName, grade);
            studentsList.add(student);
        }

        studentsList.sort(Comparator.comparing(Students::getGrade).reversed());

        for (Students student : studentsList) {
            System.out.println(student);
            //System.out.printf("%s %s: %.2f%n", s.getFirstName(), s.getLastName(), s.getGrade());
        }
    }
}
