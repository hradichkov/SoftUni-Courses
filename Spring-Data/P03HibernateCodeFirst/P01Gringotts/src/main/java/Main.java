package P03HibernateCodeFirst.P01Gringotts.src.main.java;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
         Persistence.createEntityManagerFactory("soft_uni").createEntityManager();

    }
}
