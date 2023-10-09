package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.AccountDAO;
import no.hvl.dat250.gruppe1.pollingproject.dao.PollDAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Account;
import no.hvl.dat250.gruppe1.pollingproject.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    private PollDAO dao;

    @PostMapping("/")
    public Poll create(@RequestBody Poll poll) {
        dao.create(poll);
        return poll;
    }

    @GetMapping("/{id}")
    public Poll read(@PathVariable int id) {
        Poll poll = dao.findOneById(id);
        if (poll == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        return poll;
    }

    @PutMapping("/{id}")
    public Poll update(@PathVariable int id, @RequestBody Poll poll) {
        if (dao.findOneById(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        poll.setId((long) id);
        dao.update(poll);
        return poll;
    }

    @DeleteMapping("/{id}")
    public Poll delete(@PathVariable int id) {
        Poll poll = dao.findOneById(id);
        if (poll == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        dao.deleteById(id);
        return poll;
    }

}
