package cz.muni.fi.j002.cardgamee.jsf;

import cz.muni.fi.j002.cardgamee.model.BetType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
@Named
public class Utils {

    public BetType[] getBetTypes() {
        return BetType.values();
    }
}
