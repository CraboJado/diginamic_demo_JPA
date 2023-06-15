package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        try(EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo_JPA_cleverCloud");
            EntityManager em =emFactory.createEntityManager();) {
            System.out.println(em);
            LOG.info("connection is" + em);
        }
    }
}
