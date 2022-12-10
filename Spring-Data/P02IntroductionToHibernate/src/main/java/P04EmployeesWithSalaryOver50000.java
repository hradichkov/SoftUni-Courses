import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class P04EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<String> richEmployees = entityManager.createQuery("SELECT e.firstName FROM Employee e" +
                                " WHERE e.salary > 50000",
                        String.class)
                .getResultList();

        System.out.println(String.join("\n", richEmployees));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
