package no.hvl.dat250.gruppe1.pollingproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import no.hvl.dat250.gruppe1.pollingproject.PollingprojectApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import no.hvl.dat250.gruppe1.pollingproject.model.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class AccountDAO implements InterfaceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public AccountDAO() {}
    public AccountDAO(EntityManager em){entityManager = em;}

    @Override
    public Account findOneById(int id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        return entityManager.createQuery("from " + Account.class.getName(), Account.class)
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
