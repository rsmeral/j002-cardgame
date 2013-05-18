package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Game;
import cz.muni.fi.j002.cardgamee.model.Round;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Hibernate;

@Stateless
public class GameRepository {

    @PersistenceContext
    private EntityManager em;

    public Game load(Game game) {
        Game g = em.find(Game.class, game.getId());
        Hibernate.initialize(g.getPlayers());
        Hibernate.initialize(g.getRounds());
        for (Round r : g.getRounds()) {
            Hibernate.initialize(r.getPlayerStates());
        }
        Hibernate.initialize(g.getDeck());

        return g;

    }

    public void delete(Game game) {
        em.remove(em.find(Game.class, game.getId()));
    }

    public void save(Game game) {
        em.merge(game);
    }

    public void create(Game game) {
        em.persist(game);
    }
}
