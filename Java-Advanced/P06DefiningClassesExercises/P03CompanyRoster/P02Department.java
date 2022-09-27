package P06DefiningClassesExercises.P03CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class P02Department {
    String name;
    List<P02Employee> employees;

    public P02Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public double averageSalary() {
//        return employees.stream().mapToDouble(e -> e.getSalary()).average().orElse(0);
        return employees.stream().mapToDouble(P02Employee::getSalary).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<P02Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<P02Employee> employees) {
        this.employees = employees;
    }
}
