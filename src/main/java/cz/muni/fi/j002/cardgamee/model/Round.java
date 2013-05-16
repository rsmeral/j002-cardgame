package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Entity
public class Round implements Serializable {

    @Id
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PlayerState> playerStates = new ArrayList<PlayerState>();

    private Card card;

    private boolean skipped = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean add(PlayerState e) {
        return playerStates.add(e);
    }

    public PlayerState remove(int index) {
        return playerStates.remove(index);
    }

    public List<PlayerState> getPlayerStates() {
        return playerStates;
    }
    
    
}
