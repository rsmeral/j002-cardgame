package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Game;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class GameRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public void delete(Game game) {
        em.remove(game);
    }
    
    public void save(Game game) {
        em.merge(game);
    }
    
    public void create(Game game) {
        em.persist(game);
    }
    
}
