package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.*;

@Entity
public class Round implements Serializable {

    @Id
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Map<PlayerState, Bet> playersBets;

    private Card card;

    private Boolean skipped;

}
