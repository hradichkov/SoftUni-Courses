import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08GetEmployeeWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        int empId = Integer.parseInt(scanner.nextLine());

        entityManager.getTransaction().begin();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
                .setParameter("id", empId)
                .getSingleResult();

        System.out.printf("%s %s - %s%n%s",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                employee.getProjects().stream()
                        .sorted(Comparator.comparing(Project::getName))
                        .map(Project::getName)
                        .collect(Collectors.joining(System.lineSeparator()))
        );

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
