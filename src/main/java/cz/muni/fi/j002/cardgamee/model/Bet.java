package cz.muni.fi.j002.cardgamee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class Bet implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "val")
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
