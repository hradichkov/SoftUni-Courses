import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P11FindEmployeesByFirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        String inputPattern = scanner.nextLine();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :pattern",
                        Employee.class)
                .setParameter("pattern", inputPattern + "%")
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
