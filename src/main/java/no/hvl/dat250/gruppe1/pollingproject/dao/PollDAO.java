package no.hvl.dat250.gruppe1.pollingproject.dao;

import no.hvl.dat250.gruppe1.pollingproject.model.Poll;
import org.springframework.stereotype.Component;

// Note: Despite not being used, this is required for Spring to recognize the "DAO<T>" bean.
@Component
public class PollDAO extends DAO<Poll> {
    public PollDAO() { super(Poll.class); }
}
