package cz.muni.fi.j002.cardgamee.model;

import javax.persistence.*;
import java.math.BigDecimal;

import java.util.Map;

@Entity
public class Round {

    @Id
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Map<PlayerState, BigDecimal> playersBets;


    private Card card;

    private Boolean skipped;





}
