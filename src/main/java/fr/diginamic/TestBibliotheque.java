package fr.diginamic;

import fr.diginamic.entities.Client;
import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.LocalDate.now;

public class TestBibliotheque {
    public static void main(String[] args) {
        try(EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo_JPA_cleverCloud");
            EntityManager em = emFactory.createEntityManager();){
            em.getTransaction().begin();

            Emprunt emprunt = em.find(Emprunt.class,2);
            if(emprunt != null) {
                Set<Livre> livres = emprunt.getLivres();
                for (Livre l:livres
                ) {
                    System.out.println(l);
                }
            }


            Client client = em.find(Client.class,1);
            if( client != null ){
                Set<Emprunt> emprunts = client.getEmprunts();
//                System.out.println(emprunts);
                for (Emprunt e:emprunts
                     ) {
                    System.out.println("emprent n°" + e + "lié au client " + e.getClient());
                }
            }

            // ajouter un new emprunt pour livre id 1 et 2 pour client n 3
//            LocalDate currentDate = now();
//            Set<Livre> livres = new HashSet<>();
//            Livre livre1 = em.find(Livre.class,1);
//            Livre livre2 = em.find(Livre.class,2);
//            livres.add(livre1);
//            livres.add(livre2);
//
//            Client client1 = em.find(Client.class,1);
//
//
//            Emprunt newEm = new Emprunt(currentDate, 10,null,client1,livres);
//            em.persist(newEm);
//            System.out.println(newEm);


            em.getTransaction().commit();

        }
    }
}
