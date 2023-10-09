package no.hvl.dat250.gruppe1.pollingproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
public class Poll implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pollCode; // todo: UniqueConstraint
    private String title;
    private String description;

    @ManyToMany
    private Collection<Account> whitelist;
    private boolean privatePoll;

    private Date startDate;
    private Date endDate;
    private boolean closed;

    @ManyToOne
    private Account pollOwner;
    @OneToMany
    private Collection<Vote> votes;

}
