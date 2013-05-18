package cz.muni.fi.j002.cardgamee.util;

import cz.muni.fi.j002.cardgamee.model.BetType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
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

    @Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
