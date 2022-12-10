import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class P06AddingANewAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String addressText = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressText);
        entityManager.persist(address);

        String lastName = scanner.nextLine();

        entityManager.createQuery("UPDATE Employee e" +
                        " SET e.address = :address" +
                        " WHERE e.lastName = :lastName")
                .setParameter("lastName", lastName)
                .setParameter("address", address)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
