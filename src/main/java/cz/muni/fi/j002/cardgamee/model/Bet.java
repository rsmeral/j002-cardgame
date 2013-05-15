package cz.muni.fi.j002.cardgamee.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Bet {

    @Id
    private Long id;

    @Column(name="val")
    private BigDecimal value;
    
    @Enumerated
    private BetType type;
    
}
