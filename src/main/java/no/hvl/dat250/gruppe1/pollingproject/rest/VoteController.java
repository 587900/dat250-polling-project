package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.VoteDAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteDAO dao;

    @PostMapping("/")
    public Vote create(@RequestBody Vote vote) {
        dao.create(vote);
        return vote;
    }

    @GetMapping("/{id}")
    public Vote read(@PathVariable int id) {
        Vote vote = dao.findOneById(id);
        if (vote == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        return vote;
    }

    @PutMapping("/{id}")
    public Vote update(@PathVariable int id, @RequestBody Vote vote) {
        if (dao.findOneById(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        vote.setId((long) id);
        dao.update(vote);
        return vote;
    }

    @DeleteMapping("/{id}")
    public Vote delete(@PathVariable int id) {
        Vote vote = dao.findOneById(id);
        if (vote == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account does not exist");
        dao.deleteById(id);
        return vote;
    }

}
