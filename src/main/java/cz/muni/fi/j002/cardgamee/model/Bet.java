package cz.muni.fi.j002.cardgamee.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bet {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="val")
    private BigDecimal value;
    
    @Enumerated
    private BetType type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }
}
