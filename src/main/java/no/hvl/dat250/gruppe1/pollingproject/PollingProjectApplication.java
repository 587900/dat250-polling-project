package no.hvl.dat250.gruppe1.pollingproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.gruppe1.pollingproject.dao.DAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Account;
import no.hvl.dat250.gruppe1.pollingproject.model.Poll;
import no.hvl.dat250.gruppe1.pollingproject.model.Vote;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
public class PollingProjectApplication {

    public static final String PERSISTENCE_UNIT_NAME = "jpa-pollingapp";

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
        a.setRole(Account.Role.ADMIN);

        Account b = new Account();
        b.setEmail("Rorje@live.com");
        b.setUsername("Rorje");
        b.setPassword("dsfhewiufhcsk1");
        b.setRole(Account.Role.USER);

        Poll p = new Poll();
        p.setDescription("Is pineapple good on pizza");
        p.setClosed(false);
        p.setPollOwner(a);
        p.setStartDate(new Date());
        p.setEndDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
        p.setPollCode(412);

        a.getPolls().add(p);

        Vote v = new Vote();
        v.setCreationDate(new Date());
        v.setVoteSelection(Vote.VoteSelection.GREEN);
        v.setPoll(p);
        v.setVoter(a);

        DAO<Account> ad = new DAO<>(Account.class, em);
        ad.create(a);
        ad.create(b);

        DAO<Poll> pd = new DAO<>(Poll.class, em);
        pd.create(p);

        DAO<Vote> vd = new DAO<>(Vote.class, em);
        vd.create(v);

        Collection<Account> listA = ad.findAll();
        Collection<Poll> listB = pd.findAll();
        Collection<Vote> listC = vd.findAll();

        for (Account i : listA) System.out.println(i.getEmail());
        for (Poll i : listB) System.out.println(i.getDescription());
        for (Vote i : listC) System.out.println(i.getVoteSelection());

    }

}
