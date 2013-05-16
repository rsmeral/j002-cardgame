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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<PlayerState, Bet> getPlayersBets() {
        return playersBets;
    }

    public void setPlayersBets(Map<PlayerState, Bet> playersBets) {
        this.playersBets = playersBets;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Boolean getSkipped() {
        return skipped;
    }

    public void setSkipped(Boolean skipped) {
        this.skipped = skipped;
    }
}
