import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class P02ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Town t SET t.name = upper(t.name) WHERE length(t.name) <= 5");
        query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
