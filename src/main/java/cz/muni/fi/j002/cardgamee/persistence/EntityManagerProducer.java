package cz.muni.fi.j002.cardgamee.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager(){
        return em;
    }

}
