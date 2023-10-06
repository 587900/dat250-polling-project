package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.AccountDAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDAO dao;

    @PostMapping("/")
    public Account create(@RequestBody Account account) {
        System.out.println("Creating account");
        dao.create(account);
        return account;
    }

    @GetMapping("/{id}")
    public Account read(@PathVariable int id) {
        Account acc = dao.findOneById(id);
        if (acc == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        return acc;
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable int id, @RequestBody Account account) {
        if (dao.findOneById(id) == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        account.setAccountid((long)id);
        dao.update(account);
        return account;
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id) {
        Account acc = dao.findOneById(id);
        if (acc == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        dao.deleteById(id);
        return acc;
    }

}
