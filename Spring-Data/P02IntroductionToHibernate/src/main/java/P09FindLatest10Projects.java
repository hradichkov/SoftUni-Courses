import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class P09FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT p FROM Project p" +
                        " ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                                "Project Description: %s%n" +
                                "Project Start Date: %s%n" +
                                "Project End Date: %s%n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate().minusHours(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")),
                        p.getEndDate()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
