import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class P13RemoveTowns {

    private final static String PRINT_FORMAT = "%d address%s in %s deleted%n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        Town town = entityManager.createQuery("SELECT t FROM Town t" +
                        " WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a" +
                        " WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", townName)
                .getResultList();

        entityManager.getTransaction().begin();

        addresses.forEach(address -> {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            address.setTown(null);
            entityManager.remove(address);
        });

        entityManager.remove(town);

        entityManager.getTransaction().commit();

        System.out.printf(PRINT_FORMAT,
                addresses.size(),
                addresses.size() != 1 ? "es" : "",
                town.getName());

        entityManager.close();
    }
}