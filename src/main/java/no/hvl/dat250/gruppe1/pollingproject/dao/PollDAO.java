package no.hvl.dat250.gruppe1.pollingproject.dao;

import jakarta.persistence.EntityManager;
import no.hvl.dat250.gruppe1.pollingproject.model.Account;
import no.hvl.dat250.gruppe1.pollingproject.model.Poll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PollDAO implements InterfaceDAO{

    private EntityManager entityManager;

    public PollDAO(EntityManager em){
        entityManager = em;
    }

    @Override
    public Account findOneById(int id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Poll> findAll() {
        return entityManager.createQuery("from " + Poll.class.getName(), Poll.class)
                .getResultList();
    }

    @Override
    public void create(Object entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Object entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Object entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(int entityId) {
        Account p = findOneById(entityId);
        if (p != null) {
            entityManager.remove(p);
        }
    }
}
