package no.hvl.dat250.gruppe1.pollingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public class DAO<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> clazz;

    public DAO(Class<T> clazz) { this.clazz = clazz; }
    public DAO(Class<T> clazz, EntityManager em) { this(clazz); entityManager = em; }

    public T findOneById(int id) {
        return entityManager.find(clazz, id);
    }

    public Collection<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName(), clazz).getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(int entityId) {
        T t = findOneById(entityId);
        if (t != null) entityManager.remove(t);
    }
}
