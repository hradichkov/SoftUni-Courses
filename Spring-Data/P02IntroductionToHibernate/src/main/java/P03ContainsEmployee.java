import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P03ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] searchedName = scanner.nextLine().split(" ");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Long result = entityManager.createQuery("SELECT COUNT(e) FROM Employee e WHERE" +
                                " e.firstName = :first_name AND" +
                                " e.lastName = :last_name",
                        Long.class)
                .setParameter("first_name", searchedName[0])
                .setParameter("last_name", searchedName[1])
                .getSingleResult();

        if (result > 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
