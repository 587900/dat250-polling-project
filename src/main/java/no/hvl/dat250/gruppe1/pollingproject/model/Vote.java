package no.hvl.dat250.gruppe1.pollingproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Vote implements Serializable, IHasID {

    public enum VoteSelection { GREEN, RED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account voter; // null = public
    @ManyToOne
    private Poll poll;

    private Date creationDate;

    @Enumerated(EnumType.STRING)
    private VoteSelection voteSelection;

}