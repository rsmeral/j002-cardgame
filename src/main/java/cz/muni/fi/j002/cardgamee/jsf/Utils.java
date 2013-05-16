package cz.muni.fi.j002.cardgamee.jsf;

import cz.muni.fi.j002.cardgamee.model.BetType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@Named
public class Utils {

    @PersistenceContext
    private EntityManager em;
    
    public BetType[] getBetTypes() {
        return BetType.values();
    }
    
    @Produces
    public EntityManager getEm() {
        return em;
    }
}
