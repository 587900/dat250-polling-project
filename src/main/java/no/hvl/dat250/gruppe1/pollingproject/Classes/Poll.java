package no.hvl.dat250.gruppe1.pollingproject.Classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
@Entity
@Getter
@Setter
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollId;

    private int pollCode;
    private String title;
    private String description;
    private int timeLimit;
    private boolean status;
    private int greenVotes;
    private int redVotes;

    @ManyToOne()
    private Account pollowner;




}
