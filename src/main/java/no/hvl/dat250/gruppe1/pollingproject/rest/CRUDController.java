package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.DAO;
import no.hvl.dat250.gruppe1.pollingproject.model.IHasID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

public abstract class CRUDController<T extends IHasID> {

    private static final String DOES_NOT_EXIST = "resource does not exist";
    private static final String RESOURCE_DELETED = "resource was deleted successfully";

    private DAO<T> dao;

    public CRUDController(DAO<T> dao) { this.dao = dao; }

    @PostMapping("/")
    public T create(@RequestBody T t) {
        dao.create(t);
        return t;
    }

    @GetMapping("/{id}")
    public T read(@PathVariable int id) {
        T t = dao.findOneById(id);
        if (t == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOES_NOT_EXIST);
        return t;
    }

    @PutMapping("/{id}")
    public T update(@PathVariable int id, @RequestBody T t) {
        if (dao.findOneById(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOES_NOT_EXIST);
        t.setId((long) id);
        dao.update(t);
        return t;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        T t = dao.findOneById(id);
        if (t == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, DOES_NOT_EXIST);
        dao.deleteById(id);
        return RESOURCE_DELETED;
    }

}
