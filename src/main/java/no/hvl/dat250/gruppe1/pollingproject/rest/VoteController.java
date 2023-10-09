package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.DAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController extends CRUDController<Vote> {
    public VoteController(@Autowired DAO<Vote> dao) { super(dao); }
}