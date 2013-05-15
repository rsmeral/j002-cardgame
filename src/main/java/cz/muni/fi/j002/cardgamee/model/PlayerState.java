package cz.muni.fi.j002.cardgamee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class PlayerState {

    @Id
    private Long id;

    @OneToOne
    private Player player;

    private BigDecimal balance;

}
