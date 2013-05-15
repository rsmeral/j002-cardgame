package cz.muni.fi.j002.cardgamee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Game {

    @Id
    private Long id;

    @OneToMany
    private List<Round> rounds;

    @OneToMany
    private List<PlayerState> players;

    @OneToMany
    private List<Card> deck;

    private Integer score;

    @OneToOne
    private Player winner;


    private Boolean finished;





}
