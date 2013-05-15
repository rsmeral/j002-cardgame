package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Game implements Serializable {

    @Id
    private Long id;

    @OneToMany
    private List<Round> rounds;

    @OneToMany
    private List<Player> players;

    /**
     * Initial card deck 
     */
    @OneToMany
    private List<Card> deck;
    
    @Column(name="status")
    @Enumerated
    private GameState state;
    
    private Integer score;

    @ManyToOne
    private Player winner;

    private Boolean finished;

    
}
