package no.hvl.dat250.gruppe1.pollingproject.dao;

import no.hvl.dat250.gruppe1.pollingproject.model.Vote;
import org.springframework.stereotype.Component;

// Note: Despite not being used, this is required for Spring to recognize the "DAO<T>" bean.
@Component
public class VoteDAO extends DAO<Vote> {
    public VoteDAO() { super(Vote.class); }
}
