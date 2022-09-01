package P06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06Students2 {
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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")) {
            boolean isExisting = false;

            String[] data = input.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            String age = data[2];
            String city = data[3];

            if (studentList.size() == 0) {
                Student studentToAdd = new Student(firstName, lastName, age, city);
                studentList.add(studentToAdd);
            } else {
                for (Student student : studentList) {
                    if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                        student.setAge(age);
                        student.setCity(city);
                        isExisting = true;
                    }
                }
                if (!isExisting) {
                    Student studentToAdd = new Student(firstName, lastName, age, city);
                    studentList.add(studentToAdd);
                }
            }
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
