package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.DAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends CRUDController<Account> {
    public AccountController(@Autowired DAO<Account> dao) { super(dao); }
}