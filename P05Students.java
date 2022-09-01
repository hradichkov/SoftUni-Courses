package P06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String city;

        Student(String firstName, String lastName, String age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            String age = data[2];
            String city = data[3];

            Student student = new Student(firstName, lastName, age, city);
            studentList.add(student);

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        printStudent(studentList, command);
    }

    private static void printStudent(List<Student> studentList, String command) {
        for (Student student : studentList) {
            if (command.equals(student.getCity())) {
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
