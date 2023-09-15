package no.hvl.dat250.gruppe1.pollingproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.gruppe1.pollingproject.Classes.Account;
import no.hvl.dat250.gruppe1.pollingproject.Classes.Poll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PollingprojectApplication {

    private static final String PERSISTENCE_UNIT_NAME = "jpa-pollingapp";

    public static void main(String[] args) {
        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
            em.getTransaction().begin();
            createObjects(em);
            em.getTransaction().commit();
        }
    }
    private static void createObjects(EntityManager em) {

        Account a = new Account();
        a.setEmail("Torje@sklbb.no");
        a.setUsername("Torje");
        a.setPassword("password123");
        a.setRole("ADMIN");
        a.setAdmin(true);

        Account b = new Account();
        b.setEmail("Rorje@live.com");
        b.setUsername("Rorje");
        b.setPassword("dsfhewiufhcsk1");
        b.setRole("USER");
        b.setAdmin(false);

        Poll p = new Poll();
        p.setDescription("Is pineapple good on pizza");
        p.setStatus(true);
        p.setPollowner(a);
        p.setGreenVotes(50);
        p.setRedVotes(50);
        p.setTimeLimit(10000);
        p.setPollCode(412);

        a.getPolls().add(p);

        em.persist(a);
        em.persist(b);
        em.persist(p);

    }

}
