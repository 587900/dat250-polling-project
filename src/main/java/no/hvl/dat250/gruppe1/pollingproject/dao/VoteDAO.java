package no.hvl.dat250.gruppe1.pollingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import no.hvl.dat250.gruppe1.pollingproject.model.Vote;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class VoteDAO implements InterfaceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public VoteDAO(EntityManager em){
        entityManager = em;
    }

    @Override
    public Vote findOneById(int id) {
        return entityManager.find(Vote.class, id);
    }

    @Override
    public List<Vote> findAll() {
        return entityManager.createQuery("from " + Vote.class.getName(), Vote.class)
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
        Vote p = findOneById(entityId);
        if (p != null) {
            entityManager.remove(p);
        }
    }
}
