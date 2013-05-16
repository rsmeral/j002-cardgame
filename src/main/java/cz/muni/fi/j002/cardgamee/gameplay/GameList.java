package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Game;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GameList {

    private static final int BEST_GAMES_COUNT = 10;

    @PersistenceContext
    private EntityManager em;

    @Produces
    @Named("savedGames")
    public List<Game> getSaved() {
        return em.createQuery("select g from Game g where g.finished=false", Game.class).getResultList();
    }

    @Produces
    @Named("bestGames")
    public List<Game> getBest() {
        return em.createQuery("select g from Game g order by g.score desc", Game.class)
                .setMaxResults(BEST_GAMES_COUNT).getResultList();
    }
}
