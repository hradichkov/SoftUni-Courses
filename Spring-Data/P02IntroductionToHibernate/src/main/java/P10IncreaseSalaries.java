import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class P10IncreaseSalaries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN (1, 2, 3, 14)")
                .executeUpdate();

//        entityManager.createQuery("SELECT e FROM Employee e" +
//                                " WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')",
//                        Employee.class)
//                .getResultList()
//                .forEach(e -> {
//                    e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
//                    entityManager.persist(e);
//                });

        entityManager.createQuery("SELECT e FROM Employee e" +
                                " WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')",
                        Employee.class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
