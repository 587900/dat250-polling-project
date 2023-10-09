package no.hvl.dat250.gruppe1.pollingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import no.hvl.dat250.gruppe1.pollingproject.model.Poll;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class PollDAO implements InterfaceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public PollDAO(EntityManager em){
        entityManager = em;
    }

    @Override
    public Poll findOneById(int id) {
        return entityManager.find(Poll.class, id);
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
        Poll p = findOneById(entityId);
        if (p != null) {
            entityManager.remove(p);
        }
    }
}
