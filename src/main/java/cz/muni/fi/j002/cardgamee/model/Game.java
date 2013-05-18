package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Round> rounds = new ArrayList<Round>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Player> players;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateStarted;

    @DecimalMin(value = "0")
    @Transient
    private BigDecimal initialBalance;

    private int numOfRounds;

    /**
     * Initial card deck
     */
    @ElementCollection
    private List<Card> deck;

    @Column(name = "status")
    @Enumerated
    private GameState state = GameState.NEW;

    private BigDecimal score = new BigDecimal(0);

    @ManyToOne
    private Player winner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void addRound(Round e) {
        rounds.add(e);
        numOfRounds = rounds.size();
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
        return numOfRounds - 1;
    }

    public Card getCurrentCard() {
        return deck.get(getCurrentRoundIndex());
    }

    public Card getNextCard() {
        return deck.get(getCurrentRoundIndex() + 1);
    }

    public Round getCurrentRound() {
        // TODO: UGLY!! WARNING!! EXCEPTIONS NOT HANDLED!!
        return rounds.get(getCurrentRoundIndex());
    }

    public boolean isLastRound() {
        return numOfRounds == deck.size();
    }

    public boolean isFirstRound() {
        return getCurrentRoundIndex() == 0;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<String>();
        for (Player p : getPlayers()) {
            names.add(p.getName());
        }
        return names;
    }

    public void viewRound(int roundIndex) {
        numOfRounds = roundIndex;
    }

    public List<Card> getDrawnCards() {
        return new ArrayList<Card>(deck.subList(0, getCurrentRoundIndex()));
    }
}
