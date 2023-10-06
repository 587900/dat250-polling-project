package no.hvl.dat250.gruppe1.pollingproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountid;

    private boolean isAdmin;

    private String username;
    private String password;
    private String email;
    private String role;

    @OneToMany(mappedBy = "pollowner")
    private Collection<Poll> polls = new ArrayList<>();

}