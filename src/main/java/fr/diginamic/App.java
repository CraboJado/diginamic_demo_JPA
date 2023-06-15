package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        try(EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo_JPA_cleverCloud");
            EntityManager em =emFactory.createEntityManager();) {
            System.out.println(em);
        }
    }
}
