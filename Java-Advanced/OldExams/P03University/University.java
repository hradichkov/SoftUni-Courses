package OldExams.P03University;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String result = null;

        if (getStudentCount() >= capacity) {
            result = "No seats in the university";
        }
        if (students.contains(student)) {
            result = "Student is already in the university";
        }

        if (result == null) {
            students.add(student);
            result = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }

        return result;
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        return students.stream()
                .map(s -> String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", s.getFirstName(),s.getLastName(),s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
