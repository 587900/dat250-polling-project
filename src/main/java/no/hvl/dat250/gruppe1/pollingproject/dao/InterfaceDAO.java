package no.hvl.dat250.gruppe1.pollingproject.dao;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T> {

    public T findOneById(int id);
    public List<T> findAll();
    public void create( T entity );
    public void update( T entity );
    public void delete( T entity );
    public void deleteById( int entityId );


}
