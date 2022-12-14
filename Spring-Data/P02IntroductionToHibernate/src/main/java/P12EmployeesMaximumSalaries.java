
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class P12EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e.department.name, MAX(e.salary) FROM Employee e " +
                        "GROUP BY e.department " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(object -> System.out.println(object[0] + " " + object[1]));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
