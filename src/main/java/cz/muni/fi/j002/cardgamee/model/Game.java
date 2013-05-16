package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Game implements Serializable {

    @Id
    private Long id;

    @OneToMany
    private List<Round> rounds = new ArrayList<Round>();

    @OneToMany
    private List<Player> players;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateStarted;

    private BigDecimal initialBalance;

    /**
     * Initial card deck
     */
    @ElementCollection
    private List<Card> deck;

    @Column(name = "Status")
    @Enumerated
    private GameState state = GameState.NEW;

    private BigDecimal score = new BigDecimal(0);

    @ManyToOne
    private Player winner;

    private boolean finished = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public int getCurrentRoundIndex() {
        return rounds.size();
    }

    public Card getCurrentCard() {
        return deck.get(getCurrentRoundIndex());
    }

    public Card getNextCard() {
        return deck.get(getCurrentRoundIndex() + 1);
    }

    public Round getCurrentRound() {
        // TODO: UGLY!! WARNING!! EXCEPTIONS NOT HANDLED!! 
        return rounds.get(rounds.size() - 1);
    }

    public boolean isLastRound() {
        return getCurrentRoundIndex() == deck.size();
    }
}
