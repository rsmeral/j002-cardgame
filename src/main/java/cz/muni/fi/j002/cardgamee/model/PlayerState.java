package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class PlayerState implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Player player;

    private BigDecimal balance;

    @OneToOne(cascade = CascadeType.ALL)
    private Bet bet = new Bet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
