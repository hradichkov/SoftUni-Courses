import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P05EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String department = "Research and Development";

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name = :departmentName" +
                        " ORDER BY e.salary, e.id",
                        Employee.class)
                .setParameter("departmentName", department)
                .getResultList();

        for (Employee e : employees) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    e.getFirstName(),
                    e.getLastName(),
                    department,
                    e.getSalary());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
