package fr.diginamic;

import fr.diginamic.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        try(EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("demo_JPA_cleverCloud");
            EntityManager em =emFactory.createEntityManager();) {

            em.getTransaction().begin();

            Livre livre = em.find(Livre.class, 1);
            if (null != livre) {
                System.out.println(livre);
            }

            Livre newLivre = new Livre("bonTitre","author1");
            em.persist(newLivre);

            Livre livreUpdate = em.find(Livre.class, 5);
            if (null != livreUpdate) {
                livreUpdate.setTitle("Du plaisir dans la cuisine");
            }

            TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.title='Du plaisir dans la cuisine'", Livre.class);
            Livre livre1 = query.getResultList().get(0);
            System.out.println("***************"+livre1);

            TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.authord='Emile Zola'", Livre.class);
            Livre livre2 = query2.getResultList().get(0);
            System.out.println("***************"+livre2);

            Livre livreASupprimer = em.find(Livre.class, 8);
            if (null != livreASupprimer) {
                em.remove(livreASupprimer);
            }

            TypedQuery<Livre> query3 = em.createQuery("select l from Livre l", Livre.class);
            List<Livre> livre3 = query3.getResultList();
            LOG.info("livre3" + livre3);

            em.getTransaction().commit();
        }catch (Exception e){
            LOG.error(e.getMessage());
        }
    }
}
