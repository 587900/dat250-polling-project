package no.hvl.dat250.gruppe1.pollingproject.rest;

import no.hvl.dat250.gruppe1.pollingproject.dao.DAO;
import no.hvl.dat250.gruppe1.pollingproject.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController extends CRUDController<Poll> {
    public PollController(@Autowired DAO<Poll> dao) { super(dao); }
}